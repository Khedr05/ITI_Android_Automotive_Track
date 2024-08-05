# Creating a Custom Package in Buildroot

## Description

This guide provides step-by-step instructions for creating and integrating a custom package into Buildroot.

## Steps

### 1. Create Package Structure

Navigate to the `path/buildroot/package` directory and create the necessary directories and files:

```bash
cd path/buildroot/package
mkdir mypackage
cd mypackage
mkdir src
touch Config.in
touch src/mypackage.cpp
touch mypackage.mk
touch src/Makefile
```

- Directory Structure:

```bash
path/buildroot/package/mypackage/
├── Config.in
├── mypackage.mk
└── src/
    ├── Makefile
    └── mypackage.cpp
```

![View Directory Structure Image](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/09_customPackageInBuildroot/img/00_structure.png)

### 2. Create Package Source Code

Edit the `mypackage.cpp` file:

```bash
nano src/mypackage.cpp
```

- Source Code Content:

```cpp
#include <iostream>

int main(void) 
{
    std::cout << "Hello from mypackage\n" << std::endl;
    return 0;
}
```

### 3. Create Makefile

Edit the `Makefile` in the `src` directory:

```bash
nano src/Makefile
```

- Makefile Content:

```makefile
.PHONY: clean
.PHONY: all

all: mypackage

mypackage: mypackage.cpp
    $(CXX) -o $@ $<

clean:
    -rm mypackage
```

### 4. Define Config.in File

Edit the `Config.in` file:

```bash
nano Config.in
```

- Config.in File Content:

```makefile
config BR2_PACKAGE_MYPACKAGE
    bool "mypackage"
    help
        This option enables the mypackage package.
```

### 5. Define mypackage.mk File

Edit the `mypackage.mk` file:

```bash
nano mypackage.mk
```

- mypackage.mk File Content:

```makefile
MYPACKAGE_VERSION = 1.0
MYPACKAGE_SITE = package/mypackage/src
MYPACKAGE_SITE_METHOD = local

define MYPACKAGE_BUILD_CMDS
    $(MAKE) CC="$(TARGET_CC)" LD="$(TARGET_LD)" -C $(@D)
endef

define MYPACKAGE_INSTALL_TARGET_CMDS
    $(INSTALL) -D -m 0755 $(@D)/mypackage $(TARGET_DIR)/usr/bin
endef

$(eval $(generic-package))
```

### 6. Integrate Your Package into Buildroot

To include your package in Buildroot’s configuration, add it to the top-level `package/Config.in` file:

```bash
source "package/mypackage/Config.in"
```

![View Config.in Integration Image](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/09_customPackageInBuildroot/img/01_Config.png)

### 7. Verify Package Appearance in Buildroot Menuconfig

Update Buildroot’s configuration and verify that your package appears in the menu:

```bash
cd ..
cd ..
make menuconfig
```

![View Menuconfig Image](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/09_customPackageInBuildroot/img/02_menuConfig.png)

---
