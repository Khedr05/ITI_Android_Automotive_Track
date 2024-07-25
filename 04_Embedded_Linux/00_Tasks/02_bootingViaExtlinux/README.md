---

### Loading Kernel & DTB Files using extlinux.conf & bootflow scan command

1. **Create a Directory and Configuration File:**
   - Create a directory named `extlinux`.
   - Within this directory, create a file named `extlinux.conf`.
   
   
   ![Directory Structure](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/02_bootingViaExtlinux/img/00_tree.png)
   
   


    ```bash 
     	LABEL booting
             KERNEL ../zImage
             FDT ../vexpress-v2p-ca9.dtb 
    ``` 
3. **Test with QEMU:**
   - Launch QEMU to test the setup:

     ```bash
     sudo qemu-system-arm -M vexpress-a9 -nographic -kernel u-boot -sd sd.img
     ```

4. **Set `bootcmd` Environment Variable:**
   - Set the `bootcmd` environment variable to `bootflow scan`:

     ```bash
     setenv bootcmd bootflow scan
     ```

5. **Restart the Board:**
   - Restart the board:

     ```bash
     reset
     ```
---
