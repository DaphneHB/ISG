
.PHONY: all clean

LIBNAME = ppimm

ifeq ($(OS),Windows_NT)
PATH := ../../PP_libs/msys/1.0/bin;$(PATH)
ENTETELIB =
EXE = .exe
LIB = .dll 
OPT =
OPTLIB = -Wl,--add-stdcall-alias,--output-def,$(LIBNAME).def,--out-implib,lib$(LIBNAME).a
FILE_SUPPR = $(LIBNAME).def lib$(LIBNAME).a
else
ENTETELIB = lib
EXE = 
LIB = .so
OPT = -fPIC
OPTLIB = -fPIC -lrt
FILE_SUPPR = *~
endif

PP_DIR = ../../pp
INCLUDE_DIRS = . $(PP_DIR)

IMMLIB = $(ENTETELIB)$(LIBNAME)$(LIB)
PPLIB = $(ENTETELIB)pp-client$(LIB)

CIBLES = example$(EXE) example_imm$(EXE) example_algo$(EXE)

# Addition of "-I" in front of each source directories
INCLUDES = $(foreach tmp, $(INCLUDE_DIRS),-I$(tmp)) 

all: $(CIBLES)

example$(EXE): example.c $(PPLIB)
	g++ -o $@ $< $(INCLUDES) -L. -lpp-client

example_algo$(EXE): example_algo.c $(PPLIB)
	g++ -o $@ $< $(INCLUDES) -L. -lpp-client

example_imm$(EXE): example_imm.c $(IMMLIB)
	g++ -o $@ $< -L. -lppimm

$(PPLIB):
	cd $(PP_DIR) && $(MAKE)
	cp $(PP_DIR)/$(PPLIB) .

$(IMMLIB): PP_IMM.o $(PP_DIR)/$(ENTETELIB)pp-client$(LIB)
	g++ -shared -o $@ $< $(OPTLIB) -L. -lpp-client

PP_IMM.o: PP_IMM.c PP_IMM.h $(PP_DIR)/PP_Client.h $(PP_DIR)/PP.h $(PP_DIR)/PP_Error.h
	g++ -c $< $(INCLUDES) $(OPT)

clean:
	rm $(CIBLES) *.o *$(LIB) $(FILE_SUPPR)