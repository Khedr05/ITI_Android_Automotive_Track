---
# Calculator Application

## Overview

This project is a simple calculator application written in C. The project is organized with separate directories for source files, header files, compiled object files, and the final executable. The Makefile included in the project simplifies the build process.

## Directory Structure

```
project/
├── Makefile
├── src/       # Source files (.c)
├── include/   # Header files (.h)
├── bin/       # Compiled object files (.o)
└── build/     # Final executable
```

## Prerequisites

To compile and run this application, you need to have the following installed:

### On Windows

- **MSYS2**: A software distribution and a building platform for Windows.
- **GCC**: The GNU Compiler Collection, which is usually included with MSYS2.

### On Linux

- **Make**: A build automation tool.
- **GCC**: The GNU Compiler Collection.

## Setup MSYS2 (Windows Only)

1. **Download and install MSYS2** from [msys2.org](https://www.msys2.org/).
2. **Update MSYS2** packages by running the following commands in the MSYS2 shell:

    ```sh
    pacman -Syu
    ```

3. **Install necessary packages**:

    ```sh
    pacman -S gcc make
    ```

## Building the Application

### On Windows

1. **Open the MSYS2 shell**.
2. **Navigate to the project directory**:

    ```sh
    cd /path/to/your/project
    ```

3. **Compile the application** by running the `make` command:

    ```sh
    make
    ```

   This command will:
   - Compile all `.c` files in the `src` directory.
   - Place the compiled object files in the `bin` directory.
   - Link the object files to create the `calculator` executable in the `build` directory.

### On Linux

1. **Open a terminal**.
2. **Install Make** (if not already installed):

    ```sh
    sudo apt-get install make
    ```

3. **Navigate to the project directory**:

    ```sh
    cd /path/to/your/project
    ```

4. **Compile the application** by running the `make` command:

    ```sh
    make
    ```

## Running the Application

1. **After compiling**, run the executable:

    ```sh
    ./build/calculator
    ```

## Cleaning the Build Artifacts

To remove all compiled files and directories (`bin` and `build`), run the following command:

```sh
make clean
```

## Notes

- Make sure to replace `/path/to/your/project` with the actual path to your project directory.
- If you encounter any issues or need further assistance, please refer to the MSYS2 or Linux documentation or seek help from online communities.

---
