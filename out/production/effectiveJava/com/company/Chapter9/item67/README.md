# Item 67 謹慎地優化

```
More computing sins are committed in the name of efficiency (without necessarily achieving it)
than for any other single reason—including blind stupidity.

—William A. Wulf [Wulf72]
```
```
We should forget about small efficiencies,
say about 97% of the time: premature optimization is the root of all evil.

—Donald E. Knuth [Knuth74]
```
```
We follow two rules in the matter of optimization:

Rule 1. Don’t do it.

Rule 2 (for experts only). Don’t do it yet—that is,
not until you have a perfectly clear and unoptimized solution.

—M. A. Jackson [Jackson75]
```


* **Strive to write good programs rather than fast ones.**
* 良好的程式展現資訊隱藏原則(information hiding)：在單一模組中最小化設計決策, 改變單個模組不影響其他部分 => 高內聚，低耦合

* 必須在設計過程考慮性能問題：系統完成後才改變系統的某個基本面, 會導致系統結構不好

* 努力避免那些限制性能的設計：系統完成後, 最難動的是模組之間與模組對外交互關聯的組件,
    * ex: API, 協議好的格式, 事後不可能改變

* API設計要考慮性能：API設計會直接影響性能
    * ex: java.awt.Component 的 getSize() 會回傳 Dimension 物件
    * 1個小的Dimension 物件 沒什麼, 100萬個呢?

* 為獲得好的效能而對API進行包裝是一個不好的想法
    * 被包裝的問題可能會在未來發行版本不存在, 但包裝後的API和其衍伸的問題會永遠跟著你

* 設計出清新.簡明.良好結構的程式後, 就到了可以考慮優化性能的時候

* **在做優化的前後, 做效能測試**
    * 通常效能不會變太多, 或是更差, 也可能會找錯要優化的對象, 導致花90%在10%的code上

* 善用分析工具找出效能問題點
    * JMH http://tutorials.jenkov.com/java-performance/jmh.html
    * other sample: http://irfen.me/java-jmh-simple-microbenchmark/

* 為何需要用分析工具:
    * Java本身沒有很強的效能模型(performance model)
    * 開發者寫的語言跟CPU執行的語言存在語意溝(semantic gap)
    * 不同的JVM, 不同的發行版本, 不同的處理器也有不同影響

* 結論：
    * **do not strive to write fast programs—strive to write good ones**
      1. 先設計出好程式
      2. 測量效能好壞
      3. 分析工具找出問題
      4. 檢驗演算法是否選得不好
      5. 修改程式碼
      6. 重複以上步驟直到滿意


