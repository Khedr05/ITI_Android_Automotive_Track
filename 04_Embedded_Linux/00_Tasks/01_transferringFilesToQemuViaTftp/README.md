### Transferring zImage & .dtb Files from Host Server to QEMU via TFTP Protocol

#### Setting Up the Host Server (x86)

1. **Install TFTP Protocol:**
   ```bash
   sudo apt install tftpd-hpa
   ```

2. **Configure TFTP Options:**
   Edit the configuration file to ensure TFTP allows both read and write operations (`--secure` and `--create` options):
   ```bash
   sudo nano /etc/default/tftpd-hpa
   ```
   If `--create` is missing, add it as shown in the snippet below:
   
   
   ![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/01_transferringFilesToQemuViaTftp/img/00_tftpOption.png)


3. **Restart TFTP Service:**
   ```bash
   systemctl restart tftpd-hpa
   ```

4. **Verify TFTP Service Status:**
   ```bash
   systemctl status tftpd-hpa
   ```
   Ensure the service is running:
  
  
   ![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/01_transferringFilesToQemuViaTftp/img/01_running.png)


5. **Adjust Directory Permissions for QEMU:**
   Change ownership of the TFTP directory to make it accessible by QEMU:
   ```bash
   chown tftp:tftp /srv/tftp
   ```

6. **Prepare Files for Transfer:**
   Place the files (`zImage` and `myfile.dtb`) in the TFTP directory:
   ```bash
   cd /srv/tftp
   sudo vim zImage
   sudo vim myfile.dtb
   ```

#### Setting Up vExpress Board in QEMU

1. **Edit bootcmd Environment Variable:**
   Set the IP address of the host machine and load the files using TFTP commands:
   ```bash
   "
   setenv serverip 192.168.1.5;
   saveenv;
   tftp $kernel_addr_r zImage;
   tftp $fdt_addr_r myfile.dtb;
   "
   ```

2. **Reset the Board:**
   ```bash
   reset
   ```

   After reset, confirm successful file loading:
  
  
   ![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/01_transferringFilesToQemuViaTftp/img/03_loadingFiles.png)


#### Verification

1. **Verify zImage Loading:**
   Check the memory location `$kernel_addr_r` to ensure `zImage` is loaded:
   ```bash
   md $kernel_addr_r
   ```

   
   ![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/01_transferringFilesToQemuViaTftp/img/04_kernel_addr_r.png)


2. **Verify myfile.dtb Loading:**
   Check the memory location `$fdt_addr_r` to ensure `myfile.dtb` is loaded:
   ```bash
   md $fdt_addr_r
   ```
  
  
   ![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/01_transferringFilesToQemuViaTftp/img/05_fdt_addr_r.png)


---
