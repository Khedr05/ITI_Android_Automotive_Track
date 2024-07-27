
### Dual Boot Between Two Root Filesystems With Initramfs

#### 1 - Create the Bash Script

Create a bash script named `bootManagerScript.sh` to handle user choices for booting.

```bash
#!/bin/sh

# Display options to the user
echo "1) Boot with rootfs 1"
echo "2) Boot with rootfs 2"

# Prompt for user input
echo "Please enter your choice: "
read choice

# Process user input
case "$choice" in
    1) 
        echo "You chose to boot with rootfs 1"
        echo "Changing root file system to partition 2"
        mount -t ext4 /dev/mmcblk0p2 /mnt/root
        chroot /mnt/root /bin/sh
        ;;
    2) 
        echo "You chose to boot with rootfs 2"
        echo "Changing root file system to partition 3"
        mount -t ext4 /dev/mmcblk0p3 /mnt/root
        chroot /mnt/root /bin/sh
        ;;
    *) 
        echo "Invalid option. Booting with rootfs 1"
        echo "Changing root file system to partition 2"
        mount -t ext4 /dev/mmcblk0p2 /mnt/root
        chroot /mnt/root /bin/sh
        ;;
esac
```

- Change the script owner to `root`:

```bash
sudo chown root:root /path/bootManagerScript.sh
```

- Make the script executable:

```bash
chmod +x /path/bootManagerScript.sh
```

#### 2 - Modify the `inittab` File

Edit the `inittab` file in your local root filesystem to automatically execute the bash script after booting into the initramfs.

```bash
# inittab file 
#-------------------------------------------------------
# When the system starts up, execute the "rcS" script
::sysinit:/etc/init.d/rcS
# Run the bash script to choose the partition
::sysinit:/etc/init.d/bootManagerScript.sh
# Start "askfirst" shell on the console (Prompt the user to press any key)
ttyAMA0::askfirst:-/bin/sh
# Restart the init process, executing "init"
::restart:/sbin/init
```

- Copy `bootManagerScript.sh` to `/etc/init.d`:

```bash
sudo cp /path/bootManagerScript.sh /etc/init.d/
```

#### 3 - Create a New ext4 Partition

Create a new ext4 partition on your virtual SD card to hold the second root filesystem using a disk management application.

- Mount the SD card as a loop device:

```bash
sudo losetup -f --show --partscan path/sd.img
```

- Open the disk management application.

- Select the free space, then click "+".

![Disk Management](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/06_dualBootingWithInitramfs/img/00_disk.png)

- Choose the desired size (e.g., `100MB`), then click "Next".

![Choose Size](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/06_dualBootingWithInitramfs/img/01_chosseSize.png)

- Enter a name (e.g., `rootfs2`) and set the type to `ext4`, then click "Create".

![Name & Type](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/06_dualBootingWithInitramfs/img/02_name%26type.png)

#### 4 - Copy Root Filesystems

- Create a directory named `root` under `/mnt` and copy your root filesystems to the new ext4 partition:

```bash
sudo mkdir /mnt/root
sudo cp -r /media/sherif/rootfs/* /media/sherif/rootfs2
```

![Root Filesystem](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/06_dualBootingWithInitramfs/img/03_rootfs2.png)

- Add indicator files to each root filesystem:

```bash
sudo touch /media/sherif/rootfs/helloFromRootfs1
sudo touch /media/sherif/rootfs2/helloFromRootfs2
```

![Root Filesystem Indicators](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/06_dualBootingWithInitramfs/img/04_rootfsfile1.png)
![Root Filesystem Indicators](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/06_dualBootingWithInitramfs/img/05_rootfsfile2.png)

#### 5 - Create a Compressed Image from the Root Filesystem

```bash
cd path/rootfs
find . | cpio -H newc -ov --owner root:root > ../initramfs.cpio
cd ..
gzip initramfs.cpio
mkimage -A arm -O linux -T ramdisk -d initramfs.cpio.gz uRamdisk
```

#### 6 - Copy zImage, DTB, and uRamdisk Files

- Copy the kernel image and Device Tree Blob to the TFTP directory:

```bash
sudo cp path/linux/arch/arm/boot/zImage /srv/tftp
sudo cp path/uRamdisk /srv/tftp
sudo cp path/linux/arch/arm/boot/dts/arm/*-ca9.dtb /srv/tftp
```

#### 7 - Launch QEMU

```bash
sudo qemu-system-arm -M vexpress-a9 -nographic -net nic -net tap,ifname=tap0,script=myNetwork -kernel u-boot -sd sd.img
```

#### 8 - Set Environment Variables

```bash
setenv kernel_addr_r    0x60100000
setenv fdt_addr_r       0x60000000
setenv initramfs_addr_r 0x60000000

setenv bootcmd "serverip 192.168.1.5; tftp $kernel_addr_r zImage; tftp $fdt_addr_r vexpress-v2p-ca9.dtb; tftp $initramfs_addr_r /dualBootImage/uRamdisk; bootz $kernel_addr_r $initramfs_addr_r $fdt_addr_r"

setenv bootargs "console=ttyAMA0,115200 root=/dev/mmcblk0p2 rootfstype=ext4 rw rootwait"

saveenv
```

#### 9 - Boot with Rootfs 1

- When prompted by the script, press `1`.

![Boot with Rootfs 1](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/06_dualBootingWithInitramfs/img/06_rootfs1.png)

- As shown in the screenshot, the indicator file created in rootfs1, named helloFromRootfs1, is displayed.

#### 10 - Boot with Rootfs 2

- When prompted by the script, press `2`.

![Boot with Rootfs 2](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/06_dualBootingWithInitramfs/img/07_rootfs2.png)

- As shown in the screenshot, the indicator file created in rootfs2, named helloFromRootfs2, is displayed.

---
