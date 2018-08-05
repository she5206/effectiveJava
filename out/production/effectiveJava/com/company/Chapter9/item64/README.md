# Item 64: 透過介面來參照物件

* 如果有適合的介面型態可用,就應該透過介面型態宣告:
  * parameters
  * return values
  * variables
  * fields - 儲存物件的狀態, 是variable的一種

* 只有當產生物件的時候需要用到物件的class

```
// Good - uses interface as type

Set<Son> sonSet = new LinkedHashSet<>();
```

```
// Bad - uses class as type!

LinkedHashSet<Son> sonSet = new LinkedHashSet<>();
```

* 用interface 較有彈性, 只需要修改constructor

```
Set<Son> sonSet = new HashSet<>();
```

* 周圍的程式可以繼續運作, 對於這種變化沒有影響

* 警告: 如果原本周圍的code有依賴物件的特殊功能, 新的物件也必須提供相同功能
  * ex: LinkedHashSet 有排序規則, HashSet不保證順序

* 什麼情況會改變實作的物件?
  * 追求更好的效能
  * 功能面上的需求改變
    * ex: HashMap換成用LinkedHashMap可以確保順序性, 性能差不多, 也不需要做特殊處理

* 為什麼不能同時改物件聲明和改實作就好? 我一次copy paste兩個都改就好拉!
  * 客戶端可能還是用原本的物件傳進來, 就爆炸拉

* 什麼情況適合直接參照物件的類別?
  * (1) Value Class: 值類通常是final, 而且很少有相關的interface, 所以可以直接拿來參照使用
    * ex: String and BigInteger
    * BigInteger sum = BigInteger.valueOf(0);
  * (2) Class-based Framework: 通常是抽象類別
    * ex: java.io classes' OutputStream
    * [demo] example 1
  * (3) 沒有適當的interface: 物件本身需要額外的方法
    * ex: PriorityQueue 有comparator方法但 Queue interface沒有

* 上述的例子只代表部分可以直接使用類別作為參照的情況,
實務上, 一個物件是否有適當的介面是顯而易見的,
如果沒有適合的interface, 則使用類別階層中提供必要方法的最基礎類
  * ex: A extend B extend C extend D, 若D可以滿足需求就選D



