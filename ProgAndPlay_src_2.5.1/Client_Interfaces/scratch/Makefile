
.PHONY: all clean

LIB_NAME = ProgAndPlayPlugin

ifeq ($(OS),Windows_NT)
PATH := ../../PP_libs/msys/1.0/bin;$(PATH)
ENTETELIB1 = 
ENTETELIB2 = 
LIB1 = .dll
LIB2 = .dll
OPT =
OPTLIB = -Wl,--add-stdcall-alias,--output-def,$(LIB_NAME).def,--out-implib,lib$(LIB_NAME).a
SUPPR = lib$(LIB_NAME).a $(LIB_NAME).def
else
ENTETELIB1 =
ENTETELIB2 = lib
LIB1 =
LIB2 = .so
OPT = -fPIC
OPTLIB = -fPIC -lrt
SUPPR = *~
endif

PP_DIR = ../../pp
INCLUDE_DIRS = . $(PP_DIR)

PPLIB = $(ENTETELIB2)pp-client$(LIB2)

CIBLE = $(ENTETELIB1)$(LIB_NAME)$(LIB1)

# Ajout de "-I" devant chaque répertoire contenant des sources
INCLUDES = $(foreach tmp, $(INCLUDE_DIRS),-I$(tmp)) 

all: $(CIBLE)

$(CIBLE): $(LIB_NAME).o $(PPLIB)
	g++ -shared -o $@ $< $(OPTLIB) -L. -lpp-client

$(LIB_NAME).o: $(LIB_NAME).c
	g++ -c $< $(INCLUDES) $(OPT)

$(PPLIB):
	cd $(PP_DIR) && $(MAKE)
	cp $(PP_DIR)/$(PPLIB) .

clean:
	rm $(CIBLE) $(PPLIB) $(LIB_NAME).o $(SUPPR)
