### Loading Kernel & DTB Files using extlinux.conf & bootflow scan command

1. **Create a Directory and Configuration File:**
   - Create a directory named `extlinux`.
   - Within this directory, create a file named `extlinux.conf`.



2. **Configure `extlinux.conf`:**
   - Add the following script to `extlinux.conf` to specify the kernel (`zImage`) and device tree (`vexpress-v2p-ca9.dtb`) files:

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

6. **Verify Boot Process:**
   - Confirm that the board successfully loads the files and starts the kernel:



---
