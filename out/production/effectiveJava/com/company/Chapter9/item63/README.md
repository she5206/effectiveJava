# item 63 當心字串連接符號(+)的效能

* 為連接n個字串, 而重複使用字串連接符號, 耗費n平方時間
[example1/Example1]
```
// Inappropriate use of string concatenation - Performs poorly!

public String statement() {

    String result = "";

    for (int i = 0; i < numItems(); i++)

        result += lineForItem(i);  // 反覆連接字串

    return result;

}
```

* **For performance, use a StringBuilder in place of a String**
[example2/Example2]
```
public String statement() {

    StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);

    for (int i = 0; i < numItems(); i++)

        b.append(lineForItem(i));

    return b.toString();

}
```

* 如果numItems = 100, lineForItem返回一個固定長度是80的字串符號, 第二種方法快6.5倍

* 第一種方法隨著數量平方增加, 第二種方法則是線性, 所以數目越多差異越顯著

* 使用default大小的StringBuilder, 也還是比第一種方法快5.5倍

* 結論：**不要使用字串連接符號來操作多個字串, 應該使用StringBuilder的append方法,**
或是使用character array, 或是一次只處理一個字串符