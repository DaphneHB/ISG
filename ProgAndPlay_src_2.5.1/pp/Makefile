# Compile with g++ 4.4 or later

.PHONY: all clean

LIB_NAME_CLIENT = pp-client
LIB_NAME_SUPPLIER = pp-supplier

ifeq ($(OS),Windows_NT)
PATH := ../PP_libs/msys/1.0/bin;$(PATH)
ENTETELIB = 
LIB = .dll
OPT =
OPTLIB_CLIENT = -L../PP_Libs/boost_lib -lboost_thread-mt -Wl,--add-stdcall-alias,--output-def,$(LIB_NAME_CLIENT).def,--out-implib,lib$(LIB_NAME_CLIENT).a
OPTLIB_SUPPLIER = -Wl,--add-stdcall-alias,--output-def,$(LIB_NAME_SUPPLIER).def,--out-implib,lib$(LIB_NAME_SUPPLIER).a
INCLUDE_DIRS = . ../PP_libs
SUPPR = lib$(LIB_NAME_CLIENT).a lib$(LIB_NAME_SUPPLIER).a $(LIB_NAME_CLIENT).def $(LIB_NAME_SUPPLIER).def
else
ENTETELIB = lib
LIB = .so
OPT = -fPIC
OPTLIB_CLIENT = -lboost_thread-mt -fPIC -lrt
OPTLIB_SUPPLIER = $(OPTLIB_CLIENT)
INCLUDE_DIRS = .
SUPPR = *~
endif

CIBLE_CLIENT = $(ENTETELIB)$(LIB_NAME_CLIENT)$(LIB)
CIBLE_SUPPLIER = $(ENTETELIB)$(LIB_NAME_SUPPLIER)$(LIB)

# Addition of "-I" in front of each source directories
INCLUDES = $(foreach tmp, $(INCLUDE_DIRS),-I$(tmp)) 

all: $(CIBLE_CLIENT) $(CIBLE_SUPPLIER)

$(CIBLE_CLIENT): PP_Client.o PP_Error.o
	g++ -shared -o $@ $^ $(OPTLIB_CLIENT)

$(CIBLE_SUPPLIER): PP_Supplier.o PP_Error.o
	g++ -shared -o $@ $^ $(OPTLIB_SUPPLIER)

PP_Supplier.o: PP_Supplier.cpp PP_Supplier.h PP.h
	g++ -c $< $(INCLUDES) $(OPT)

PP_Client.o: PP_Client.cpp PP_Client.h PP_Client_Private.h PP.h
	g++ -c $< $(INCLUDES) $(OPT)
	
PP_Error.o: PP_Error.c PP_Error.h PP_Error_Private.h
	g++ -c $< $(INCLUDES) $(OPT)

clean:
	rm *.o *$(LIB) $(SUPPR)
