
.PHONY: all clean

LIBNAME = adaDevice

ifeq ($(OS),Windows_NT)
PATH := ../../PP_libs/msys/1.0/bin;$(PATH)
ENTETELIB =
EXE = .exe
LIB = .dll 
OPTLIB = -Wl,--add-stdcall-alias,--output-def,$(LIBNAME).def,--out-implib,lib$(LIBNAME).a
FILE_SUPPR = $(LIBNAME).def lib$(LIBNAME).a
else
ENTETELIB = lib
EXE = 
LIB = .so
OPTLIB =
FILE_SUPPR = *~
endif

PP_DIR = ../../pp
INCLUDE_DIRS = . $(PP_DIR)

ADALIB = $(ENTETELIB)$(LIBNAME)$(LIB)
PPLIB = $(ENTETELIB)pp-client$(LIB)

# Addition of "-I" in front of each source directories
INCLUDES = $(foreach tmp, $(INCLUDE_DIRS),-I$(tmp)) 

all: example$(EXE)

example$(EXE): example.adb $(PPLIB) $(ADALIB)
	gnatmake -I. -L. $< -largs -ladaDevice -largs -lpp-client

$(PPLIB):
	cd $(PP_DIR) && $(MAKE)
	cp $(PP_DIR)/$(PPLIB) .

$(ADALIB): adaDevice.o $(PPLIB)
	g++ -shared -o $@ $< -L. $(OPTLIB) -lpp-client

adaDevice.o: adaDevice.c $(PP_DIR)/PP_Client.h
	g++ -c $< $(INCLUDES)

clean:
	rm *.o *.ali *$(LIB) example$(EXE) $(FILE_SUPPR)