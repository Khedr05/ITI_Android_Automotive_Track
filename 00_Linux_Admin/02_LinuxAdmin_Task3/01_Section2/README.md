# Linux Admin Task 3

1 - List the user commands and redirect the output to /tmp/commands.list ?


![ls temp](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/ls%20to%20tmp%20cmd.png)


![ls temp output](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/ls%20temp.png)


2 - Edit in your profile to display date at login and change your prompt permanently ?


![edit bashrc](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/date%20in%20bashrc.png)


![date in terminal](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/date%20in%20terminal.png)


![edit prompt](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/edit%20ps1.png)


![ps1 in terminal](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/ps1%20on%20terminal.png)


3 - What is the command to count the word in a file or number of file in directory ?

wc 

a - Count the number of user commands ?


![user count](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/user%20count.png)


4 - What happens if you execute 

a. cat filename1 | cat filename2 ?

b. ls | rm ?

ls outputs a list of files and directories and rm will attempt to delete them based on that list However ls output includes directory names and other special files which rm cannot handle directly as arguments without specific flags (-r, -f, etc.) Therefore this command would likely result in an error or unexpected behavior

![cat](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/cat%20.png)


c. ls /etc/passwd | wc –l ?


![wc /etc/passwd](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/wc.png)


5 - Write a command to search for all files on the system that, its name is “.profile” ?


![profile](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/profile.png)


6 - List the inode numbers of /, /etc, /etc/hosts ?


![ls /](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/node%20root.png)


![ls /etc](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/etc%20node.png)


![ls /etc/hosts](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/node%20etc%20hosts.png)


7 - Create a symbolic link of /etc/passwd in /boot ?


![s link](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/soft%20link.png)


8 - Create a hard link of /etc/passwd in /boot. Could you? Why ?


![h link](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/ls%20hardlink.png)


9 - Echo \ it will jump to the next line, and will print >
Notice the prompt ”>” what is that? and how can you change it from “>” to “:”.


![nano bashrc](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/nano%20bashrc.png)


![ps2](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/ps2.png)


![source](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/run%20bashrc.png)


![echo ps2](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/02_LinuxAdmin_Task3/01_Section2/Snip/echo%20ps2.png)


NOTE: search the usage of PS1

Here's what each part of this PS1 variable does:

\u : Username of the current user.
\h : Hostname up to the first ".".
\w : Current working directory.
\t: Current time in 24-hour HH:MM format.
\n: Newline.
\$ : Displays a "$" for a regular user and "#" for root user.

[\$(date "+%H:%M:%S")] : Current time in format HH:MM
    










