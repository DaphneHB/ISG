.PHONY: all clean

ifeq ($(OS),Windows_NT)
CAML_PATH = ../../PP_libs/OCaml
PATH := ../../PP_libs/msys/1.0/bin;../../PP_libs/MinGW-gcc3.4.5/bin;$(CAML_PATH)/bin;$(PATH);
CAML_LIB_PATH = $(CAML_PATH)/lib
INCLUDE_CAML_LIB = -I $(CAML_LIB_PATH)
ENTETELIB = 
LIB = .dll
OPTLIB = -L../../PP_libs/MinGW-gcc3.4.5/lib -ldopt -noentry
FILE_SUPPR = 
else
INCLUDE_CAML_LIB = 
ENTETELIB = lib
LIB = .so
OPTLIB = -lrt -ldopt -fPIC
FILE_SUPPR = *~
endif

PP_DIR = ../../pp
INCLUDE_DIRS = . $(PP_DIR) $(CAML_LIB_PATH)
# Addition of "-I" in front of each source directories
INCLUDES = $(foreach tmp, $(INCLUDE_DIRS),-I$(tmp)) 

PPLIB = $(ENTETELIB)pp-client$(LIB)

all: pp.cma

pp.cma: pp.cmo dllpp_ocaml$(LIB)
	ocamlc -a -o pp.cma pp.cmo -dllib dllpp_ocaml$(LIB)

pp.cmo: pp.ml
	ocamlc -c $(INCLUDE_CAML_LIB) pp.ml

dllpp_ocaml$(LIB): pp_ocaml.o $(PPLIB)
	ocamlmklib -oc pp_ocaml pp_ocaml.o -lpp-client -L. $(OPTLIB)

$(PPLIB):
	cd $(PP_DIR) && $(MAKE)
	cp $(PP_DIR)/$(PPLIB) .

pp_ocaml.o: pp_ocaml.c
	g++ -o pp_ocaml.o $(INCLUDES) -c pp_ocaml.c

clean:
	rm pp.cmi pp.cma pp.cmo pp_ocaml.o *$(LIB) libpp_ocaml.a $(FILE_SUPPR)