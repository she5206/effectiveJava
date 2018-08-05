# Item 51: 謹慎地設計method signatures

* API設計技巧
  * (1) 方法名稱:
      1. 整個檔案中的名稱風格一致性
      2. 選擇大家都認同的命名規則
  * (2) 不提供快捷的方法: 太多方法會讓類別難以學習, 只有當一個方法經常被使用才提供"shorthand"
    * 內聚力要夠強
  * (3) 避免過長的參數列表: 小於等於4個最佳, 超過4個就必須看說明, 雖然有IDE可以輔助, 但還是有可能發生順序傳錯了還能正確回傳內容, 這就很恐怖了!
      * 解決的方式:
          1. 把方法拆解成多個方法, 讓參數傳遞比較少, ex: java.util.List 的subList和indexOf結合
          2. 用helper class
          3. 用Builder
  * (4) 參數要優先使用介面, 而不是類別
      * 不使用HashpMap類作為輸入, 使用Map介面作為參數, 就可以傳入Hashtable, HashMap, TreeMap, 或是任何Map的實現
  * (5) 對於boolean, 優先考慮使用兩個元素的Enum類型
      * 擴充性比較好, 舉例:
      ``` public enum TemperatureScale { FAHRENHEIT, CELSIUS} ```
      Thermometer.newInstance(TemperatureScale.CELSIUS) 比 Thermometer.newInstance(true) 容易理解,未來還可以加入KELVIN的版本



