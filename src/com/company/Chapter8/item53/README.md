# Item 53: 謹慎地使用可變長度參數(varargs)

## 可變長度參數

範例：
```
// Simple use of varargs
static int sum(int... args) {
    int sum = 0;
    for (int arg : args)
        sum += arg;
    return sum;

}
```

結果是sum(1,2,3)=6, sum()=0

但, 不見得想支援沒有參數的情境, 如果是計算參數中的最小值, 則空值的情況不太好
上述的代碼中多加入長度判斷
```
// The WRONG way to use varargs to pass one or more arguments!
static int min(int... args) {
    if (args.length == 0)
        throw new IllegalArgumentException("Too few arguments");

    int min = args[0];
    for (int i = 1; i < args.length; i++)
        if (args[i] < min)
            min = args[i];
    return min;
}
```
問題1: 如果未帶參數, 會在執行期失敗, 而非編譯的時候
問題2: 代碼不美觀, 而且需要初始化min參數, 否則無法使用for-each

解法是指定類型的正常參數, 以解決前述的問題
```
// The right way to use varargs to pass one or more arguments
static int min(int firstArg, int... remainingArgs) {
    int min = firstArg;
    for (int arg : remainingArgs)
        if (arg < min)
            min = arg;
    return min;
}
```

如果確定有95%的機會會使用少於三個的方法, 就應該寫出五個方法

當參數的數目超過3個就該使用可變參數
```
public void foo() { }

public void foo(int a1) { }

public void foo(int a1, int a2) { }

public void foo(int a1, int a2, int a3) { }

public void foo(int a1, int a2, int a3, int... rest) { }
```

結論： 可變參數在數目不定的方法上, 使用方便, 但注意不能濫用
