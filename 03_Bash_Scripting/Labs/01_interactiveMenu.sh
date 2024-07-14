#!/bin/bash

options=("Display Date & Time" "List Files In Current Directory" "Display Current Disk Usage" "Exit")

PS3="Select Option Number : "

select option in "${options[@]}"
do
    case $option in
        "Display Date & Time")
            echo "Current date & time: $(date)"
            ;;
        "List Files In Current Directory")
            echo "Files in current directory:"
            ls
            ;;
        "Display Current Disk Usage")
            echo "Disk usage:"
            df -h
            ;;
        "Exit")
            echo "Exiting..."
            exit 0
            ;;
        *)
            echo "Invalid option. Please select a valid number."
            ;;
    esac
done