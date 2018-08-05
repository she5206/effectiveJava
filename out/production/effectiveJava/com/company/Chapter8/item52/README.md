# Item 52: 審慎地使用overloading

* [Example 1]
  * 唯一適合的是Collection<?>, 所以第三個方法被call 3次
* [Example 2]
  * 儘管物件都是Wine, 最後還是會選出最具體的覆蓋版本
* [Example 1-2]

* 避免胡亂使用重載機制
* 安全策略：永遠不能有兩個相同數目的重載方法
  * ex: ObjectOutputStream, write有write, writeBoolean(boolean), writeInt(int), writeLong(long)
  * 如果兩個參數差異很大, 不會搞混, 就不影響

* [Example 3]
  * 一般來說都會期望是[-3,-2,-1] [-3,-2,-1], 但結果是[-3,-2,-1] [-2,0,2]
    ```
    boolean remove(Object o);
    remove(int index);
    ```
      * 移除0,1,2
      * 移除第0個, 第1個, 第2個

* 當兩個重載方法在相同的參數上被調用, 執行相同功能, 重載就不會帶來危害
  ```
  // Ensuring that 2 methods have identical behavior by forwarding

  public boolean contentEquals(StringBuffer sb) {

      return contentEquals((CharSequence) sb);

  }
  ```

## 結論
* 多個相同參數數目的方法應該要避免重載方法
* 同一組參數只需要經過類型轉換就可以被傳遞給不同的重載方法
* 傳遞同樣的參數, 重載方法的行為必須一致
