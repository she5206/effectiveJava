# JNI Example (Mac OS)
```
NOTICE: the `$JAVA_HOME` can be taken from (for `1.8` version in this case):
export JAVA_HOME="$(/usr/libexec/java_home -v 1.8)"
```

JNI (Java Native Interface) allows implementing methods in C/C++, and use them in Java.

## 1. Create `JNIExample.java` file
## 2. Compile the `JNIExample.java` file
```
javac JNIExample.java
```
## 3. Codegen `.h` file for JNI
```
javah -jni JNIExample
```
## 4. Create `JNIExample.c`
## 5. Compile C library

**IMPORTANT:** library extension should exactly be `.jnilib` (not `.so`!), and should have `lib` prefix, i.e. `libjniexample.jnilib`:

```
gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin/" -o libjniexample.jnilib -shared JNIExample.c
```

## 6. Execute the java class

Notice, we set `java.library.path` to current directory, where the `libjniexample.jnilib` was compiled to:

```
java -Djava.library.path=. JNIExample
```