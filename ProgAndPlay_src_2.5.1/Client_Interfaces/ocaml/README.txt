This file describes instructions in order to test OCaml example.
Linux Users: You have to install "g++" and "ocaml" compilers as well as Boost (1.42) and "make" tool in your computer.
Windows Users: You have to download the following archive http://www.irit.fr/ProgAndPlay/ressources/PP_libs_2.3.zip and unzip it to the Prog&Play directory. The file tree must be like this:
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
	2.2) Windows users:
		2.2.1) Add path to make tool to your PATH environment variable:
			set PATH=<Prog&Play dir>/PP_libs/MinGW/bin;%PATH%
		2.2.2) Add path to ocaml binaries to your PATH environment variable:
			set PATH=<Prog&Play dir>/PP_libs/OCaml/bin;%PATH%
		2.2.3) Define OCAMLLIB environment variable:
			set OCAMLLIB=<Prog&Play dir>/PP_libs/OCaml/lib
3) Compiling:
	3.1) Linux users: write "make" command in your console
	3.2) Windows users: write "mingw32-make" command in your console
		3.2.1) If you have following error: "0 [main] us 0 init_cheap: VirtualAlloc pointer is null, Win32 error 487..." This is caused by the antivirus software you are using, disable it for temporary during compiling.
4) Launch the game
5) Run the toplevel system: Write "ocaml" command in your console
6) After the # prompt, you can type: #use "example.ml";;

Advice of use:
1) Modify the position in example with new coordinates. Compile and run example again and watch consequences in the game.
2) Inspire yourself by this example to write your own programs.

Note : All functions and constants usable with the game are described in files "./constantListKP41.ml" and "./pp.ml". Do not hesitate to consult it.