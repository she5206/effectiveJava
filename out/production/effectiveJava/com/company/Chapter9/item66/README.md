# Item 64 謹慎的使用本地方法

### JNI Example (Mac OS)

JNI (Java Native Interface) allows implementing methods in C/C++, and use them in Java.

#### 0. prequision:

NOTICE: the `$JAVA_HOME` can be taken from (for `1.8` version in this case):
```
$ export JAVA_HOME="$(/usr/libexec/java_home -v 1.8)"
```

#### 1. Create `JNIExample.java` file
#### 2. Compile the `JNIExample.java` file
```
$ javac JNIExample.java
```
#### 3. Codegen `.h` file for JNI
```
$ javah -jni JNIExample
```
#### 4. Create `JNIExample.c`
#### 5. Compile C library

**IMPORTANT:** library extension should exactly be `.jnilib` (not `.so`!), and should have `lib` prefix, i.e. `libjniexample.jnilib`:

```
$ gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin/" -o libjniexample.jnilib -shared JNIExample.c
```

#### 6. Execute the java class

Notice, we set `java.library.path` to current directory, where the `libjniexample.jnilib` was compiled to:

```
$ java -Djava.library.path=. JNIExample
```


---

* Java Native Interface(JNI): 允許java應用程式呼叫本地方法(native method), 本地方法可以透過C, C++編寫, 程式透過本地方法執行運算, 返回結果到Java程式中

* 本地方法的用途:
  * 存取特定平台的設施, ex: OS processes(Java 9)或其他Java沒有提供的功能
  * 優化效能(不推), ex: BigInterger 在1.1發行的版本中, 為了效能就是用C編寫, 但1.3後用Java調教性能完全重寫, 這些年的VM也更快
  * 真正需要高效能多精度運算的情況, 還是可以透過native method使用C++的GMP[註1]

* 本地方法的缺點:
  * 會受到內存記憶體破壞影響應用程式
  * 與平台綁定, 不在能自由移植
  * 進入和退出本地方法有固定消耗, 所以如果工作量少, 反而會讓效能降低
  * 本地方法需要膠水代碼(glue code), 難以閱讀與維護

* 結論:
  * 少用本地方法, 要用也要完整測試, 一有bug就會造成全面性毀滅


[註1] GNU MP(簡稱GMP)是一個可以進行大數運算(Big number operation)的函式庫, 使用C++實作
[註2] 膠水代碼: 黏合那些可能不相容的代碼