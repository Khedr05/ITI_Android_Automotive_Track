# Yocto Setup Guide

This guide will walk you through setting up Yocto, including installing dependencies, configuring the environment, and building an image.

## 1 - Install Dependencies

First, install the necessary dependencies:

```bash
sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python3 python3-pip python3-pexpect
```

## 2 - Clone the Poky Project

Clone the Poky project from the Yocto repository. We will use the Kirkstone version:

```bash
git clone -b kirkstone https://git.yoctoproject.org/git/poky.git
cd poky
```

## 3 - Set Up the Poky Environment

Initialize the Poky environment:

```bash
source oe-init-build-env
```

![Environment Setup](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/10_buildYocto/img/00_env.png)

## 4 - Edit the Configuration File (`local.conf`)

Navigate to the configuration directory and edit the `local.conf` file:

```bash
cd conf
vim local.conf
```

Update the following settings in `local.conf`:

- **Target Machine**  
  ![Target Machine](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/10_buildYocto/img/01_qemuarm64.png)

- **Downloads Path**  
  ![Downloads Path](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/10_buildYocto/img/02_dlDir.png)

- **Sstate Path**  
  ![Sstate Path](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/10_buildYocto/img/03_sstateDir.png)

- **Number of Cores**  
  Set the number of cores for parallel processing. Replace `Number of cores` with the actual number of cores on your host machine, and adjust the values accordingly:

  ```bash
  BB_NUMBER_THREADS ?= "1.5 * Number of cores"
  PARALLEL_MAKE ?= "-j 2 * Number of cores"
  ```

  **Example:** For a machine with 6 cores:

  ```bash
  BB_NUMBER_THREADS ?= "9"
  PARALLEL_MAKE ?= "12"
  ```

  Note: The number of cores should be an even number.

  To find the number of cores on your x86 machine:

  ```bash
  nproc
  ```

  ![Number of Cores](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/10_buildYocto/img/04_cores.png)

  **Note:** If you encounter the message `E45: 'readonly' option is set (add ! to override)`, use `:w!` to save and then `:q` to quit.

## 5 - Build Yocto

Start the Yocto build process:

```bash
bitbake -k core-image-minimal
```

![Build Process](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/10_buildYocto/img/05_end.png)

## 6 - Run QEMU

Navigate to the build directory and start QEMU:

```bash
cd build
runqemu qemuarm64 nographic
```

![Run QEMU](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/10_buildYocto/img/06_runQemu.png)

---
