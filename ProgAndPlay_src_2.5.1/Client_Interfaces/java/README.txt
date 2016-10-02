This file describes instructions in order to test Java example.
Linux Users: You have to install "g++" and Java (jdk 1.6) compilers as well as Boost (1.42) and "make" tool in your computer.
Windows Users: You have to download the following archive http://www.irit.fr/ProgAndPlay/ressources/PP_libs_2.5.zip and unzip it to the Prog&Play directory. The file tree must be like this:
	<Prog&Play dir>/Client_Interfaces/...
	<Prog&Play dir>/pp/...
	<Prog&Play dir>/README.txt
	<Prog&Play dir>/LISEZMOI.txt
	<Prog&Play dir>/PP_libs/

Remark: paths indicated below are relative to the directory where this file "README.txt" is installed.

1) Open a command prompt or a console
2) Change your working directory to the directory containing the Makefile
	2.1) Linux users: add "." to your PATH and LD_LIBRARY_PATH environment variables:
		export PATH=.:$PATH
		export LD_LIBRARY_PATH=.:$LD_LIBRARY_PATH
	2.1) Windows users:
		2.1.1) Add path to make tool to your PATH environment variable:
			set PATH=<Prog&Play dir>/PP_libs/MinGW/bin;%PATH%
		2.1.2) Add path to java binaries to your PATH environment variable:
			set PATH=<Prog&Play dir>/PP_libs/jdk1.6.0_21/bin;%PATH%
3) Compiling:
	3.1) Linux users: write "make" command in your console
		3.1.1) If java is not installed on "/usr/lib/jvm/java-6-sun" directory, you can specify it through the JAVA_PATH variable (example: make JAVA_PATH="/usr/local/lib/jvm/java-6-sun")
	3.2) Windows users: write "mingw32-make" command in your console
		3.2.1) If you have following error: "0 [main] us 0 init_cheap: VirtualAlloc pointer is null, Win32 error 487..." This is caused by the antivirus software you are using, disable it for temporary during compiling.
4) Launch the game
5) Run example: Write "java example.Example" in your console
	
Advice of use:
1) Modify the position in example with new coordinates. Compile and run example again and watch consequences in the game.
2) Inspire yourself by this example to write your own programs.
3) To compile your own program, adapt following command to your own situation:
	3.1) Windows user: javac -classpath .;pp.jar myPackage\myProgram.java
	3.1) Linux user: javac -classpath .:pp.jar myPackage/myProgram.java

Note : All functions and constants usable with the game are described in the javadoc. Do not hesitate to consult it.
Javadoc building:
1) Linux users, write "make doc" command
1) Utilisateurs Windows, write "mingw32-make doc" command