---

## Setting Up TAP Connection Between Laptop and QEMU Virtual Board

This README provides instructions for setting up a TAP connection between your laptop and a virtual board running on QEMU.

### 1. Configure TAP Interface on Host

To set up the TAP interface (`tap0`) on your host machine, execute the following commands:

```bash
sudo ip addr add 192.168.1.5/24 dev tap0
sudo ip link set tap0 up
```

Verify the configuration:

```bash
sudo ip addr show tap0
```


![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/00_bootingScript/img/00_showtap0.png)



### 2. Create Initialization Script

Create a bash script named `myNetwork` to initialize the connection with the board:

```bash
#!/bin/bash
ip addr add 192.168.1.5/24 dev $1
ip link set $1 up
```

Make the script executable:

```bash
chmod +x myNetwork
```

### 3. Launch QEMU

Start QEMU with the TAP interface using your `myNetwork` script:

```bash
sudo qemu-system-arm -M vexpress-a9 -nographic -net nic -net tap,ifname=tap0,script=myNetwork -kernel u-boot -sd sd.img
```

### 4. Configure IP Address on the Board

Once QEMU is running, set the IP address (`ipaddr`) for the board inside the QEMU environment:

```bash
setenv ipaddr 192.168.1.6
```

Replace `192.168.1.6` with your desired IP address.


![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/00_bootingScript/img/01_bdinfo.png)


## Ping the Host Server IP to Verify Connectivity


![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/00_bootingScript/img/02_networkAlive.png)


## Task: Automating Image and DTB Loading in U-Boot

### Script to Load Image & DTB File

Create a script (`script.scr`) to load images from either SD or TFTP:

```bash
if mmc dev; then
    echo "SD card detected."
    if fatload mmc 0:1 ${kernel_addr_r} zImage && fatload mmc 0:1 ${fdt_addr_r} myfile.dtb; then
        echo "Loaded zImage & myfile.dtb from SD card."
    else
        echo "Failed to load zImage or myfile.dtb from SD card."
        if ping 192.168.1.5; then
            echo "Loaded file from network via TFTP."
        else
            echo "No option available."
        fi
    fi
else
    echo "No SD card detected."
    if ping 192.168.1.5; then
        echo "Loaded file from network via TFTP."
    else
        echo "No option available."
    fi
fi
```

### Convert .scr to .img for Loading into Memory

```bash
mkimage -A arm -O linux -T script -C none -a 0 -e 0 -n "Boot Script" -d script.scr script.img
```

### Load script.img in RAM and Run It on Every Boot

To load `script.img` and execute it automatically on boot:

```bash
setenv bootcmd "load mmc 0:1 ${loadaddr} script.img; source ${loadaddr}"
saveenv
reset
```


![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/00_bootingScript/img/03_setEnvBootcmd.png)


### Testing Load from SD After Reset


![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/00_bootingScript/img/04_rest.png)


### Testing Load from TFTP

To test loading from TFTP, remove files from the SD card.


![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/00_bootingScript/img/03_setEnvBootcmd.png)


## Check if zImage Loaded Successfully in ${kernel_addr_r}


![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/00_bootingScript/img/05_kernel_addr_r.png)


## Check if myfile.dtb Loaded Successfully in ${fdt_addr_r}


![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/00_bootingScript/img/06_fdt_addr_r.png)


### Testing No Option Scenario

To simulate no network option, bring `tap0` down and run QEMU without the `myNetwork` script:

```bash
sudo ip link set tap0 down
sudo qemu-system-arm -M vexpress-a9 -nographic -net nic -net tap,ifname=tap0,script=no -kernel u-boot -sd sd.img
```


![Command Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/00_bootingScript/img/08_noOption.png)


### Notes

- Adjust IP addresses (`192.168.1.5`, `192.168.1.6`) to match your network configuration.
- Ensure TAP (`tap0`) and QEMU (`myNetwork` script) configurations meet your requirements.
- Customize QEMU parameters (`-M`, `-kernel`, `-sd`) based on your specific board specifications and file locations.

This setup facilitates effective communication between your laptop and a QEMU virtual board using a TAP interface.

--- 
