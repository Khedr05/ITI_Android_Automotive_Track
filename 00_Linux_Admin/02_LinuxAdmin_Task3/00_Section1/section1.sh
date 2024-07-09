#!/bin/bash


bashrc_file="$HOME/.bashrc"

if [ -f "$bashrc_file" ]; then
    echo ".bashrc is exist"	
    echo "export HELLO=\$HOSTNAME" >> "$bashrc_file"
    echo "export LOCAL=\$(whoami)" >> "$bashrc_file"
    echo "variables is appended"
    gnome-terminal  
else
    echo ".bashrc file not found in $HOME directory"
fi

