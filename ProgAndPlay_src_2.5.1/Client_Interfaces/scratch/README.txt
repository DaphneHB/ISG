This file describes instructions in order to test Scratch example.
Linux Users: You have to install "g++" compiler as well as Boost (1.42) and "make" tool in your computer.
Windows Users: You have to download the following archive http://www.irit.fr/ProgAndPlay/ressources/PP_libs_2.5.zip and unzip it to the Prog&Play directory. The file tree must be like this:
	<Prog&Play dir>/Client_Interfaces/...
	<Prog&Play dir>/pp/...
	<Prog&Play dir>/README.txt
	<Prog&Play dir>/LISEZMOI.txt
	<Prog&Play dir>/PP_libs/

Remark: paths indicated below are relative to the directory where this file "README.txt" is installed.

Scratch installation:
1) Install original version of Scratch:
	1.1) Linux user: http://info.scratch.mit.edu/Linux_installer
	1.2) Windows user: http://scratch.mit.edu/download
2) Patch Scratch
	2.1) Linux users:
		2.1.1) Copy/Past "./patch/locale/fr.po" to "/usr/share/scratch/locale/" directory (default).
		2.1.2) Copy/Past "./patch/Scratch.image" to "/usr/lib/scratch/" directory (default).
	2.2) Windows users: Copy/Past all files from "./patch" directory to Scratch original directory installation
	
Prog&Play library compiling:
1) Open a command prompt or a console
2) Change your working directory to the directory containing the Makefile
	2.1) Linux user: Add "." to your PATH and LD_LIBRARY_PATH environment variables:
		export PATH=.:$PATH
		export LD_LIBRARY_PATH=.:$LD_LIBRARY_PATH
	2.2) Windows users: add path to make tool to your PATH environment variable:
		set PATH=<Prog&Play dir>/PP_libs/MinGW/bin;%PATH%
3) Compiling:
	3.1) Linux users: write "make" command in your console
	3.2) Windows users: write "mingw32-make" command in your console
		3.2.1) If you have following error: "0 [main] us 0 init_cheap: VirtualAlloc pointer is null, Win32 error 487..." This is caused by the antivirus software you are using, disable it for temporary during compiling.
4) Library installation:
	4.1) Linux user: Copy/Past "ProgAndPlayPlugin" file to "/usr/lib/scratch/Plugins/" directory (default).
	4.2) Windows user: Copy/Past libraries "ProgAndPlayPlugin.dll" and "pp-client.dll" to Scratch original directory installation.
5) Launch Scratch and open example "example.sb"
6) Launch the game
7) In Scratch, clic on green flag to carry out example

Advice of use:
1) Modify target position in example with new coordinates. Run example again and watch consequences in the game.
2) Inspire yourself by this example to write your own programs.
