This file describes instructions in order to test C examples (classic interface, algorithmic interface and imm interface).
Linux Users: You have to install "g++" compiler as well as Boost (1.42) and "make" tool in your computer.
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
	2.2) Windows users: add path to make tool to your PATH environment variable:
		set PATH=<Prog&Play dir>/PP_libs/MinGW/bin;%PATH%
3) Compiling:
	3.1) Linux users: Write "make" command in your console
	3.2) Windows users: write "mingw32-make" command in your console
		3.2.1) If you have following error: "0 [main] us 0 init_cheap: VirtualAlloc pointer is null, Win32 error 487..." This is caused by the antivirus software you are using, disable it for temporary during compiling.
4) Launch the game
5) Run C example (classic): write "example" in your console
   Run C example (algorithmic): write "example_algo" in your console
   Run C example (imm): write "example_imm" in your console

Advice of use:
1) Modify the position in examples with new coordinates. Compile and run examples again and watch consequences in the game.
2) Inspire yourself by this examples to write your own programs.
3) To compile your own program, adapt following command to your own situation:
	3.1) C interface (classic)
		g++ -o myProgram myProgram.c -I. -I../../pp -L. -lpp-client
	3.2) C interface (algorithmic)
		g++ -o myProgram myProgram.c -I. -I../../pp -L. -lpp-client
	3.3) C interface (imm)
		g++ -o myProgram myProgram.c -I. -L. -lppimm

Note : All functions and constants usable with the game are described in files "./constantList_KP4.1.h", "../../pp/PP_Client.h", "../../pp/PP.h". Do not hesitate to consult it.