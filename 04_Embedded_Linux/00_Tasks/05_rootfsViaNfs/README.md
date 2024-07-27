
### Booting Kernel & Mounting Root File System via NFS

#### 1 - Install NFS on your Linux host (x86)

```bash
sudo apt install nfs-kernel-server
```

![Install NFS](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/00_installNfs.png)

#### 2 - Verify NFS Installation

```bash
systemctl status nfs-kernel-server
```

![Check NFS Status](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/01_checkNfsStatus.png)

#### 3 - Check if the NFS Server is Listening on the Default Port (2049)

```bash
ss -tulpen | grep 2049
```

![Check NFS Port](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/02_checkNfsPort.png)

#### 4 - Verify NFS Kernel Modules

```bash
lsmod | grep nfs
```

![Check NFS Modules](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/03_checkNfsModules.png)

#### 5 - View Exported Directories

```bash
cat /etc/exports
```

![View Exported Directories](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/04_exportFiles.png)

- After installation, NFS server settings are stored in `/etc/exports`. Initially, this file lists no directories. Check this file for NFS configuration details.

#### 6 - Create a Directory Under `/srv` Named `nfs`

```bash
sudo mkdir /srv/nfs
```

- `/srv/nfs` will be the shared directory between the server (x86) and the client (board).

#### 7 - Copy `rootfs` Directory to the New Directory

```bash
sudo cp -rp path/rootfs/* /srv/nfs
```

![Copy Rootfs](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/05_lsNfs.png)

#### 8 - Identify Your IP Address on x86 & Assign an IP Address to the Target (Board)

```bash
ifconfig
```

![Identify IP Address](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/06_ifconfig.png)

- My IP address is 192.168.1.11

- I will choose 192.168.1.50

- Verify if 192.168.1.50 is not assigned to any device

```bash
ping 192.168.1.50
```

![Check IP Availability](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/07_checkIp.png)

- If the destination is unreachable, it is available for assignment.
- If packets are received, it is already assigned.

#### 9 - Edit the `/etc/exports` File

```bash
sudo vim /etc/exports
```

- Add the following line to the file:

```bash
/srv/nfs 192.168.1.50(rw,no_root_squash,no_subtree_check)
```

![Edit Exports](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/08_vimExport.png)

- Restart the NFS kernel server to apply new configurations:

```bash
sudo systemctl restart nfs-kernel-server
```

#### 10 - Launch QEMU

```bash
sudo qemu-system-arm -M vexpress-a9 -nographic -net nic -net tap,ifname=tap0,script=myNetwork -kernel u-boot -sd sd.img
```

#### 11 - Set Environment Variables for x86 IP & Board IP

```bash
setenv serverip 192.168.1.11
setenv ipaddr 192.168.1.50
saveenv
```

![Set Environment Variables](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/09_setenv.png)

#### 12 - Set the `bootargs` Environment Variable

```bash
setenv bootargs 'console=ttyAMA0 root=/dev/nfs ip=192.168.1.50:::::eth0 nfsroot=192.168.1.11:/srv/nfs,nfsvers=3,tcp rw init=/sbin/init'
saveenv
```

![Set Bootargs](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/10_setBootargs.png)

#### 13 - Set Addresses for the zImage & the dtb

```bash
setenv kernel_addr_r 0x60100000
setenv fdt_addr_r 0x60000000
saveenv
```

#### 14 - Set `bootcmd` with Commands to Load zImage & dtb File via TFTP

```bash
tftp $kernel_addr_r zImage; tftp $fdt_addr_r vexpress-v2p-ca9.dtb; bootz $kernel_addr_r - $fdt_addr_r;
```

![Set Bootcmd](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/11_setBootcmd.png)

#### 15 - Reset QEMU

```bash
reset
```

#### 16 - Relaunch QEMU

- After u-boot starts,
- It will load zImage & dtb via TFTP.
- Starting kernel using the mounted root file system through NFS system.

![U-Boot Starting](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/12_ubootStarting.png)
![TFTP Load](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/13_tftpLoad.png)
![Kernel Starting](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/14_kernelStarting.png)
![Mount via NFS](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/15_mountViaNfs.png)
![Shell](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/05_rootfsViaNfs/img/16_shell.png)

---
