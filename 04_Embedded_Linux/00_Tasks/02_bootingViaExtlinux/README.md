---

### Loading Kernel & DTB file using extlinux.conf & bootflow scan cmd

#1. Create a directory named `extlinux`.

#2. Create a file named `extlinux.conf` in the new directory:


![Directory Structure](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/02_bootingViaExtlinux/img/00_tree.png)


#3. Add the following script to `extlinux.conf` to load the zImage & dtb file:

   ```bash
   LABEL booting
           KERNEL ../zImage
           FDT ../vexpress-v2p-ca9.dtb
   ```

#4. Launch QEMU to test:

   ```bash
   sudo qemu-system-arm -M vexpress-a9 -nographic -kernel u-boot -sd sd.img
   ```

#5. Set the bootcmd environment variable to bootflow scan:

   ```bash
   setenv bootcmd bootflow scan
   ```

#6. Restart the board:

   ```bash
   reset
   ```

#7. Finally, the board loads files & starts the kernel:


![Board Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/02_bootingViaExtlinux/img/01_res.png)


---
