# Item 65: 介面(interfaces)優於反射(reflection)

* java.lang.reflect 提供訪問任意類別的能力.
  * 提供一個類別物件, 就可以得到它的: Constructor, Method, and Field instances
* Reflection 讓一個類別可以使用另一個類別, 代價是:
  * 喪失編譯檢查類型的好處
  * 執行反射的程式碼笨拙又冗長
  * 效能損失 [demo] example 1/Hello.java

[demo] example 1/Example 1
* 這個例子有兩個缺點:
  * (1) 範例中有6個runtime exceptions, 如果不是用反射, 就會是compile-time errors
  * (2) 25行(reflection) v.s 1行 (constructor invocation)

* 有一些情況適合用反射
  * 程式分析工具
  * dependency injection frameworks
  * 對於一個在執行時可能不存在類別.方法.域, 使用反射是合理的, 但這種情況很少見
    * ex: doNonPublicFunction

* 結論: **避免使用反射**
  * 僅使用反射實例化編譯時未知的類別, 存取物件則使用編譯時已知的介面或超類