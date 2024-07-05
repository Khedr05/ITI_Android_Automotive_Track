# Linux Admin Task 1

1 - List three Linux Distributions ?

ubuntu, red hut, linux mint

2 - From the slides what is the man command used for ?

System-wide documentation system that provides short reference manuals (pages) for individual
commands, API functions, concepts, configuration file syntax, file formats and is organized in sections
(1 for user commands, 2 for system calls...). That's the traditional Unix documentation system.

3 - What is the difference between rm and rmdir using man command ?

rm 

![rm man](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/00_LinuxAdmin_Task1/Snip/man%20rm.png)

rmdir

![rmdir man](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/00_LinuxAdmin_Task1/Snip/man%20rmdir.png)

4 - Create the following hierarchy under your home directory ? 

![hierarchy cmd](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/00_LinuxAdmin_Task1/Snip/create%20hierarchy.png)

4.a - Remove dir11 with rmdir in one-step. What did you notice? And how did you
overcome that?

rmdir: failed to remove 'dir11': Directory not empty

what did i notice that rmdir is not allowed to remove not empty directory 

to overcome this you can use rm command with -r option to make it remove recursive antthing in the directory and then the directory

rm -r dir11

4.b - Then remove OldFiles using rmdir –p command. State what happened to the
hierarchy (Note: you are in your home directory) ?

rmdir -p ~/Documents/oldFiles

rmdir: failed to remove '/home/sherif/Documents/oldFiles': Not a directory

Nothing happen to the directory because oldFiles is a file not a directory

4.c - The output of the command pwd was /home/user. Write the absolute and
relative path for the file mycv ?

absolute : /home/docs/mycv

relative : docs/mycv

5 - Copy the /etc/passwd file to your home directory making its name is mypasswd ? 

![cp](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/00_LinuxAdmin_Task1/Snip/copy.png)

6 - Rename this new file to be oldpasswd ? 

![mv](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/00_LinuxAdmin_Task1/Snip/move.png)

7 - You are in /usr/bin, list four ways to go to your home directory ? 

![home](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/00_LinuxAdmin_Task1/Snip/4%20ways%20to%20home.png)

8 - List Linux commands in /usr/bin that start with letter w ? 

![ls w](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/00_LinuxAdmin_Task1/Snip/list%20w%20in%20bin.png)

9 - What command type are used for (from the slide) ? 

Alias : are executed before anything else.

Internal Command : is a command that is a part of the shell itself and, as such,
doesn’t have to be loaded from disk separately.

External command : is a command that exists as an executable file on the
disk of the computer.

10 - Show 2 types of command file in /usr/bin that start with letter c ? 

![ls c](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/00_LinuxAdmin_Task1/Snip/list%20c%20in%20bin.png)

11 - Using man command find the command to read file. (Note: man take option) ?

![read](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/00_LinuxAdmin_Task1/Snip/man%20read.png)

12 - What is the usage of apropos command ?

The apropos command in Linux is used to search the manual page names and descriptions for keywords. Its primary purpose is to help you find commands related to a particular topic or task by searching through the manual pages (man pages).











