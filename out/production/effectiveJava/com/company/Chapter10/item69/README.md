# item 69 只有針對例外情況才使用例外

如果你有天運氣不好, 看到以下這段程式:
```
// Horrible abuse of exceptions. Don't ever do this!

try {

    int i = 0;

    while(true)

        range[i++].climb();

} catch (ArrayIndexOutOfBoundsException e) {

}
```

* 問題在哪? 用try catch終止迴圈!!!!!!

一目瞭然的標準模式程式碼:
```
for (Mountain m : range)

    m.climb();
```

* 為什麼有人想用try-cactch, 而不寫標準模式?
  * 因為以為可以減少越界判斷來提升效能

* 實際上, 例外模式比標準模式慢了2倍
  * 例外是設計給不正常的情況, 很少有JVM會對他進行優化
  * 程式碼放進try-catch區塊, 反而阻止JVM本來可能要進行的優化
  * 標準模式並不會導致多餘的檢查, 多數的JVM會進行優化

* 例外模式還有另外的缺點, 不能保證正常運作!
  * 在例外模式中, 如果迴圈拋出不預期例外, 就會被誤當為終止條件

* 忠告：**例外應該只用於例外的情況: 永遠不適合正常的控制流**

* Iterator的next()和hasNext()方法, 讓迴圈可以尋訪集合:

```
for (Iterator<Foo> i = collection.iterator(); i.hasNext(); ) {

    Foo foo = i.next();

    ...

}
```

* 若沒有hasNext()就會變成下列做法:
```
// Do not use this hideous code for iteration over a collection!

try {

    Iterator<Foo> i = collection.iterator();

    while(true) {

        Foo foo = i.next();

        ...

    }

} catch (NoSuchElementException e) {

}
```

同時也會有效能差, 程式碼繁瑣, 掩蓋bug等問題

* 另一種做法是, 當物件是不適當的狀態時, 回傳一個可識別的值: ex: null
  * 但Iterator的next()中, null是合法回傳值,

* 狀態測試 v.s 可識別的回傳值
  * 準確性： 如果可能會被改變狀態, 造成時間間隔上的狀態變化, 產生誤差, 則選用可識別回傳值
  * 效能面： 如果會重複狀態測試方法, 從效能面, 則可以選擇可識別回傳值
  * 可讀性： 狀態測試提供可讀性, 容易檢測和改正
    * ex: 如果忘了呼叫狀態測試方法可能比忘了做可識別值檢查容易發現

* 結論 again：**例外應該只用於例外的情況: 永遠不適合正常的控制流**



