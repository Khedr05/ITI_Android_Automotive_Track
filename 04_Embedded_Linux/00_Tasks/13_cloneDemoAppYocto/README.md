# Recipe to Clone and Build DemoApp Repo Using CMake

## 1. Write the Recipe

Create a recipe file with the following content:

```bash
SUMMARY = "Clone and build DemoApp repository"
DESCRIPTION = "Fetches the repository using Git, builds it with CMake, and installs the binary."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cmake
DEPENDS = "cmake"

S = "${WORKDIR}/git"
D = "${WORKDIR}/image"

SRC_URI = "git://github.com/FadyKhalil/DemoApp.git;protocol=https;branch=main"
SRCREV = "720c663c5fd7246b4b42c5205d74db7d9784b5b2"

do_configure() {
    mkdir -p ${B}
    cd ${B}
    cmake ${S} -DCMAKE_INSTALL_PREFIX=${D}
}

do_compile() {
    oe_runmake -C ${B}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/calculator ${D}${bindir}/
}
```

![Recipe Diagram](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/13_cloneDemoAppYocto/img/00_recipe.png)

## 2. Compile the Recipe

Run the following command to compile the recipe:

```bash
bitbake gitclonerecipe
```

![Bitbake Output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/13_cloneDemoAppYocto/img/01_bitbake.png)

## 3. Check the Output of CMake

Navigate to the output directory and verify the binary:

```bash
cd ~/embedded_linux/yocto/poky/build/tmp/work/cortexa57-poky-linux/gitclonerecipe/1.0-r0/image/usr/bin
```

![Output Verification](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/13_cloneDemoAppYocto/img/02_output.png)

## 4. Extract the Expanded File

To extract the expanded environment, run:

```bash
bitbake -e gitclonerecipe > expand
```

---
