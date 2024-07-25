---

### Loading Kernel & DTB Files using extlinux.conf & bootflow scan command

1. **Create a Directory and Configuration File:**
   - Create a directory named `extlinux`.
   - Within this directory, create a file named `extlinux.conf`.

   ![Directory Structure](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/02_bootingViaExtlinux/img/00_tree.png)

2. **Configure `extlinux.conf`:**
   - Add the following script to `extlinux.conf` to specify the kernel (`zImage`) and device tree (`vexpress-v2p-ca9.dtb`) files:

     ```bash
     LABEL booting
             KERNEL ../zImage
             FDT ../vexpress-v2p-ca9.dtb
     ```



---
