### Booting Kernel from SD with BusyBox

## 1. Configuring BusyBox

1.1 **Clone the BusyBox Repository**

```bash
git clone https://github.com/mirror/busybox.git
```

1.2 **Set Environment Variables**

```bash
export ARCH=arm
export CROSS_COMPILE=~/x-tools/arm-cortexa9_neon-linux-musleabihf/bin/arm-cortexa9_neon-linux-musleabihf-
```

1.3 **Configure BusyBox**

 - Launch menuconfig to configure options:

```bash
make menuconfig
```

1.4 **Adjust Build Process to Static**

[Menuconfig Screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/03_bootingRootfsViaSd/img/00_menuConfig.png) 

 - save the configuration and exit.

1.5 **Build and Install BusyBox**

```bash
make
make install
```

## 2. Creating and Configuring the Root Filesystem (RootFS)

2.1 **Create the RootFS Directory**

 - Create a directory for the root filesystem:

```bash
mkdir rootfs
```

2.2 **Copy Compiled Binaries to RootFS**

```bash
rsync -a busybox/_install/* rootfs
```

2.3 **Create Required Directories**

```bash
mkdir -p rootfs/{boot,dev,etc,home,mnt,proc,root,srv,sys}
```

[RootFS Directory Structure](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/03_bootingRootfsViaSd/img/01_rootfs.png) 

2.4 **Create and Configure Startup Script**

 - Create the `rcS` script in `etc/init.d/`:

```bash
mkdir -p rootfs/etc/init.d
touch rootfs/etc/init.d/rcS
```

 - Edit `rcS` to include initialization commands:

```bash
#!/bin/sh
# Mount proc and sys filesystems
mount -t proc nodev /proc
mount -t sysfs nodev /sys
# Mount devtmpfs if not configured in Kernel
mount -t devtmpfs devtmpfs /dev
```

 - Make `rcS` executable:

```bash
chmod +x rootfs/etc/init.d/rcS
```

2.5 **Create and Configure inittab**

 - Create the `inittab` file in `etc`:

```bash
touch rootfs/etc/inittab
```

 - Edit `inittab` with the following content:

```bash
# Execute rcS script during system startup
::sysinit:/etc/init.d/rcS
# Start a shell on the console (ask for key press)
ttyAMA0::askfirst:-/bin/sh
# Restart init process
::restart:/sbin/init
```

2.6 **Set Ownership**

 - Ensure all files in rootfs are owned by root:

```bash
chown -R root:root rootfs
```

## 3. Mounting the SD Card

 - Mount the SD card and copy the root filesystem:

```bash
sudo losetup -f --show --partscan sd.img
cp -rp rootfs/* /media/`your username`/rootfs
```

## 4. Copying zImage & DTB Files

 - Copy the kernel image and Device Tree Blob to the TFTP directory:

```bash
sudo cp path/linux/arch/arm/boot/zImage /srv/tftp
sudo cp path/linux/arch/arm/boot/dts/arm/*-ca9.dtb /srv/tftp
```

## 5. Booting with QEMU

5.1 **Launch QEMU**

```bash
qemu-system-arm -M vexpress-a9 -m 128M -nographic -kernel path/u-boot -sd path/sd.img
```

5.2 **Set Boot Arguments**

 - Set boot arguments to pass to the kernel:

```bash
setenv bootargs 'console=ttyAMA0 root=/dev/mmcblk0p2 rootfstype=ext4 rw rootwait init=/sbin/init'
```

5.3 **Set Environment Variables for Loading**

```bash
setenv kernel_addr_r
setenv fdt_addr_r
```

5.4 **Load Files via TFTP**

```bash
tftp $kernel_addr_r zImage
tftp $fdt_addr_r vexpress-v2p-ca9.dtb
```

Refer to the [Loading Files Screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/03_bootingRootfsViaSd/img/02_loadingFiles.png) for visual guidance.

5.5 **Boot the Kernel and DTB File**

```bash
bootz $kernel_addr_r - $fdt_addr_r
```

Refer to the [Kernel Start Screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/03_bootingRootfsViaSd/img/03_kernelStart.png) for visual guidance.
