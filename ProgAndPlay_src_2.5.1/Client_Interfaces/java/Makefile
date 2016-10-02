
.PHONY: all clean

LIBNAME = pp_java

ifeq ($(OS),Windows_NT)
JAVA_PATH = ../../PP_libs/jdk1.6.0_21
PATH := ../../PP_libs/msys/1.0/bin;$(JAVA_PATH)/bin;$(PATH)
ENTETELIB = 
LIB = .dll
OPT = 
OPTLIB = -Wl,--add-stdcall-alias
FILE_SUPPR = 
JAVA_INCLUDE = win32
# SEPCLASSPATH is set to ":" due to "sh.exe" from "msys/1.0/bin". If "cmd.exe" is used set SEPCLASSPATH to ";" instead
SEPCLASSPATH = :
else
ifndef JAVA_PATH
JAVA_PATH = /usr/lib/jvm/java-6-sun
endif
ENTETELIB = lib
LIB = .so
OPT = -fPIC
OPTLIB = -fPIC -lrt
FILE_SUPPR = *~
JAVA_INCLUDE = linux
SEPCLASSPATH = :
endif

PP_DIR = ../../pp
INCLUDE_DIRS = . $(PP_DIR) $(JAVA_PATH)/include $(JAVA_PATH)/include/$(JAVA_INCLUDE)
# Addition of "-I" in front of each source directories
INCLUDES = $(foreach tmp, $(INCLUDE_DIRS),-I$(tmp)) 

JAVALIB = $(ENTETELIB)$(LIBNAME)$(LIB)
PPLIB = $(ENTETELIB)pp-client$(LIB)

# liste des fichiers .class
JAVA_EXCEP_FILES = $(wildcard ./pp/exceptions/*.java)
JAVA_FILES = $(wildcard ./pp/*.java) $(JAVA_EXCEP_FILES)
CLASS_FILES = $(JAVA_FILES:.java=.class)

all: $(CLASS_FILES) $(JAVALIB) pp.jar example/Example.class

$(JAVALIB): PP_jni.o $(PPLIB)
	g++ -shared -o $@ $< $(OPTLIB) -L. -lpp-client

$(PPLIB):
	cd $(PP_DIR) && $(MAKE)
	cp $(PP_DIR)/$(PPLIB) .

PP_jni.o: PP_jni.cpp PP_jni.h
	g++ -c PP_jni.cpp $(INCLUDES) $(OPT)

PP_jni.h: pp/PPNative.class
	javah -o PP_jni.h pp.PPNative

%.class: %.java
	javac $<

pp.jar: $(CLASS_FILES)
	jar cf pp.jar pp/*.class pp/exceptions/*.class

example/Example.class: example/Example.java pp.jar
	javac -classpath .$(SEPCLASSPATH)./pp.jar $<

clean:
	rm *$(LIB) PP_jni.o PP_jni.h pp/*.class pp/exceptions/*.class pp.jar example/*.class $(FILE_SUPPR)

doc: javadoc/index.html

javadoc/index.html: pp/PP.java pp/Unit.java pp/PendingCommand.java $(JAVA_EXCEP_FILES)
	javadoc -docencoding "ISO-8859-15" -d javadoc -author pp/PP.java pp/Unit.java pp/PendingCommand.java pp/exceptions/*.java