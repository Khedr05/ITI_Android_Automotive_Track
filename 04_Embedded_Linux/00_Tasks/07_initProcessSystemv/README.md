# Adding Custom Runlevels with System V Init

## Description
This guide demonstrates how to create two custom runlevels using the System V init process: one to start a app (`myApp`) and another to stop it.

## Steps

### 1 - Build Your Buildroot
Follow your standard procedure to build the buildroot environment.

### 2 - Run QEMU
Start QEMU with the following commands:

```bash
cd output/images
./start-qemu.sh
```

### 3 - Add a Script to Control `myApp`
Create a script to manage the starting and stopping of `myApp`. Place this script in `/etc/init.d`.

```bash
cd /etc/init.d
touch myApp
vi myApp
chmod +x myApp
```

**Content of `myApp` script:**

```bash
#! /bin/sh
case "$1" in
    start)
        echo "Starting My Service....."
        start-stop-daemon -S -n myService -a /bin/myService &
        ;;
    kill)
        echo "Killing My Service....."
        start-stop-daemon -K -n myService
        ;;
    *)
        echo "Usage: $0 {start|kill}"
        exit 1
esac
exit 0
```

![myApp script screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/07_initProcessSystemv/img/00_myApp.png)

### 4 - Create a Placeholder for `myApp` in `/bin`

```bash
cd /bin
touch myApp
vi myApp
chmod +x myApp
```

**Content of `/bin/myApp`:**

```bash
#!/bin/sh
while true
do
    echo "Hello Sherif from your service"
    sleep 5
done
```

![myApp in /bin screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/07_initProcessSystemv/img/01_myAppinbin.png)

### 5 - Create Runlevel Directories

Create two directories under `/etc` for the runlevels:

```bash
mkdir /etc/rc1.d
mkdir /etc/rc2.d
```

![Directories screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/07_initProcessSystemv/img/02_lsEtc.png)

**Create symbolic links for the runlevels:**

- For runlevel 1 to start `myApp`:

    ```bash
    ln -s /etc/init.d/myApp /etc/rc1.d/S01myApp
    ```

- For runlevel 2 to stop `myApp`:

    ```bash
    ln -s /etc/init.d/myApp /etc/rc2.d/K01myApp
    ```

![Soft links screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/07_initProcessSystemv/img/03_softlinks.png)

### 6 - Create the `rc.c` Script in `/etc/init.d`

Create and edit the `rc.c` script:

```bash
cd /etc/init.d
touch rc.c
vi rc
chmod +x rc.c
```

**Content of `rc.c` script:**

```bash
#!/bin/sh
# Check if one argument is provided
if [ $# -ne 1 ]; then
    echo "Usage: $0 <runlevel>"
    exit 1
fi

# Define the folder path based on the argument
folder="rc$1.d"

# Kill scripts starting with K
for i in /etc/$folder/K??*; do
    # Ignore dangling symlinks (if any).
    [ ! -f "$i" ] && continue
    case "$i" in
        *.sh)
            # Source shell script for speed.
            (
                trap - INT QUIT TSTP
                set stop
                . $i
            )
            ;;
        *)
            # No sh extension, so fork subprocess.
            $i stop
            ;;
    esac
done

# Start scripts starting with S
for i in /etc/$folder/S??*; do
    # Ignore dangling symlinks (if any).
    [ ! -f "$i" ] && continue
    case "$i" in
        *.sh)
            # Source shell script for speed.
            (
                trap - INT QUIT TSTP
                set start
                . $i
            )
            ;;
        *)
            # No sh extension, so fork subprocess.
            $i start
            ;;
    esac
done
```

![rc script screenshot 1](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/07_initProcessSystemv/img/04_rc.png) 
![rc script screenshot 2](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/07_initProcessSystemv/img/05_rc.png)

### 7 - Modify `inittab` to Execute the `rc.c` Script

Edit `/etc/inittab`:

```bash
vi /etc/inittab
```

Add the following lines:

```bash
rc1:1:wait:/etc/init.d/rc.c 1
rc2:2:wait:/etc/init.d/rc.c 2
```

![inittab screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/07_initProcessSystemv/img/06_inittab.png)

### 8 - Switch to Runlevel 1

```bash
init 1
```

![Switch to runlevel 1 screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/07_initProcessSystemv/img/07_init1.png)

### 9 - Switch to Runlevel 2

```bash
init 2
```

![Switch to runlevel 2 screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/07_initProcessSystemv/img/08_init2.png)

---
