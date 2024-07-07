# Linux Admin Task 2

1 - Move the binary file output to the directory /usr/local/bin with sudo permissions. Afterward, attempt to execute the binary from any working directory and explain the outcome. Provide a detailed explanation supported by evidence as to why the binary can be executed from any location ? 


![mv to bin](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/01_LinuxAdmin_Task2/Snip/binarySearch.png)


After moving binarySearch.out to /usr/local/bin/, you can execute it simply by typing binarySearch.out from any directory. This works because the shell (like Bash) automatically searches directories listed in PATH when you type a command without specifying a path. Hence, binarySearch.out is found and executed because /usr/local bin/ is in the PATH.


2 - List the available shells in your system ?


![system shells](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/01_LinuxAdmin_Task2/Snip/printShells.png)


3 - List the environment variables in your current shell ?


![env variables](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/01_LinuxAdmin_Task2/Snip/printEnvVar.png)


4 - Display your current shell name ?


![current shell](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/01_LinuxAdmin_Task2/Snip/printCurrentShell.png)


5 - Execute the following command : echo \ then press enter What is the purpose of \ ?


![backslash](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/01_LinuxAdmin_Task2/Snip/echoBackslash.png)


When you type echo \ and press Enter:
The shell interprets the backslash (\) as an escape character. Since there is no character following the backslash (because Enter is pressed right after), the shell simply treats the backslash literally.


6 - Create a Bash shell alias named PrintPath for the “echo $PATH” command ? 


![alias](https://github.com/Khedr05/ITI_Android_Automotive_Track/blob/main/00_Linux_Admin/01_LinuxAdmin_Task2/Snip/alias.png)













