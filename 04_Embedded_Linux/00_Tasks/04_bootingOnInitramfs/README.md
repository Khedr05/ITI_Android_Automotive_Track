
### Booting Kernel from SD with BusyBox

## 1 - Configuring BusyBox

1.1 - **Clone the BusyBox Repository**

```bash
git clone https://github.com/mirror/busybox.git
```

1.2 - **Set Environment Variables**

```bash
export ARCH=arm
export CROSS_COMPILE=~/x-tools/arm-cortexa9_neon-linux-musleabihf/bin/arm-cortexa9_neon-linux-musleabihf-
```

1.3 - **Configure BusyBox**

- Launch `menuconfig` to configure options:

```bash
make menuconfig
```

1.4 - **Adjust Build Process to Static**

![Menuconfig Screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/04_bootingOnInitramfs/img/00_menuConfig.png) 

- Save the configuration and exit.

1.5 - **Build and Install BusyBox**

```bash
make
make install
```

## 2 - Creating and Configuring the Root Filesystem (RootFS)

2.1 - **Create the RootFS Directory**

- Create a directory for the root filesystem:

```bash
mkdir path/rootfs
```

2.2 - **Copy Compiled Binaries to RootFS**

```bash
rsync -a path/busybox/_install/* path/rootfs/
```

2.3 - **Create Required Directories**

```bash
mkdir -p path/rootfs/{boot,dev,etc,home,mnt,proc,root,srv,sys}
```

![RootFS Directory Structure](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/04_bootingOnInitramfs/img/01_rootfs.png)

2.4 - **Create and Configure the Startup Script**

- Create the `rcS` script in `etc/init.d/`:

```bash
mkdir -p path/rootfs/etc/init.d
touch path/rootfs/etc/init.d/rcS
```

- Edit `rcS` to include initialization commands:

```bash
#!/bin/sh
# Mount proc and sys filesystems
mount -t proc nodev /proc
mount -t sysfs nodev /sys
# Mount devtmpfs if not configured in the Kernel
mount -t devtmpfs devtmpfs /dev
```

- Make `rcS` executable:

```bash
chmod +x path/rootfs/etc/init.d/rcS
```

2.5 - **Create and Configure `inittab`**

- Create the `inittab` file in `etc`:

```bash
touch path/rootfs/etc/inittab
```

- Edit `inittab` with the following content:

```bash
# Execute rcS script during system startup
::sysinit:/etc/init.d/rcS
# Start a shell on the console (ask for key press)
ttyAMA0::askfirst:-/bin/sh
# Restart the init process
::restart:/sbin/init
```

2.6 - **Set Ownership**

- Ensure all files in `rootfs` are owned by root:

```bash
chown -R root:root path/rootfs
```

## 3 - Create a Compressed Image from the RootFS Directory

```bash
cd path/rootfs
find . | cpio -H newc -ov --owner root:root > ../initramfs.cpio
cd ..
gzip initramfs.cpio
mkimage -A arm -O linux -T ramdisk -d initramfs.cpio.gz uRamdisk
```

## 4 - Copying `zImage`, DTB, and `uRamdisk` Files

- Copy the kernel image and Device Tree Blob to the TFTP directory:

```bash
sudo cp path/linux/arch/arm/boot/zImage /srv/tftp
sudo cp path/uRamdisk /srv/tftp
sudo cp path/linux/arch/arm/boot/dts/arm/*-ca9.dtb /srv/tftp
```

## 5 - Booting with QEMU

- There are two options for booting: directly booting the kernel on `initramfs` without an SD card, or booting using U-Boot and then booting the kernel on `initramfs` with an SD card.

5.1 - **Booting the Kernel Without an SD Card**

5.1.1 - **Launch QEMU**

```bash
sudo qemu-system-arm -M vexpress-a9 -nographic -kernel path/zImage -append "console=ttyAMA0 rdinit=/bin/sh" -dtb path/vexpress-v2p-ca9.dtb -initrd path/initramfs.cpio.gz
```

- The board will boot the kernel using `initramfs`.

5.2 - **Booting with U-Boot and SD Card**

5.2.1 - **Launch QEMU**

```bash
sudo qemu-system-arm -M vexpress-a9 -nographic -net nic -net tap,ifname=tap0,script=path/myNetwork -kernel path/u-boot -sd path/sd.img
```

![Loading Files Screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/04_bootingOnInitramfs/img/02_kernelOnInitramfs.png)

5.2.2 - **Set Boot Arguments**

- Set boot arguments to pass to the kernel:

```bash
setenv bootargs "console=ttyAMA0 root=/dev/mmcblk0p2 rootfstype=ext4 rw rootwait init=/sbin/init"
```

5.2.3 - **Set Environment Variables for Loading**

```bash
setenv kernel_addr_r 0x60100000
setenv fdt_addr_r 0x60000000
setenv initramfs_addr_r 0x61000000
saveenv
```

5.2.4 - **Load Files via TFTP**

```bash
tftp $kernel_addr_r zImage
tftp $fdt_addr_r vexpress-v2p-ca9.dtb
tftp $initramfs_addr_r uRamdisk
```

![Loading Files Screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/04_bootingOnInitramfs/img/03_loadFiles.png)

5.2.5 - **Boot the Kernel and DTB File**

```bash
bootz $kernel_addr_r $initramfs_addr_r $fdt_addr_r
```

![Kernel Start Screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/04_bootingOnInitramfs/img/04_initRam.png)
![Kernel Start Screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/04_bootingOnInitramfs/img/05_KernelOnInitramfsSd.png)

---
