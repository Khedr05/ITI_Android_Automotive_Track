# Create a Custom Service with Systemd Init

## Description
This guide explains how to create and manage a custom service using Systemd. The example will demonstrate creating a service that performs a network ping operation.

## Steps

### 1 - Create the Service File

First, create the service file under `/etc/systemd/system`:

```bash
cd /etc/systemd/system
sudo touch myservice.service
sudo nano myservice.service
```

**Content of `myservice.service`:**

```ini
[Unit]
Wants=mynetwork.network

[Service]
Type=simple
ExecStart=/usr/bin/ping 192.168.1.10 -c 3
Restart=always
RestartSec=3
WorkingDirectory=/usr/bin

[Install]
WantedBy=graphical.target
```

### 2 - Create the Network File

Create the network configuration file that the service depends on:

```bash
cd /etc/systemd/system
sudo touch mynetwork.network
sudo nano mynetwork.network
```

**Content of `mynetwork.network`:**

```ini
[Unit]
Description=Network configuration for myservice

[Network]
Address=192.168.1.9/24
```

### 3 - Start and Enable the Service

Start the service and enable it to start on boot:

```bash
sudo systemctl start myservice.service
sudo systemctl enable myservice.service
```

### 4 - Check Service Logs

To ensure that the service is running correctly, view its logs:

```bash
journalctl -u myservice.service
```

![Logs screenshot](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/04_Embedded_Linux/00_Tasks/08_initProcessSystemd/img/00_afterRun.png)

---
