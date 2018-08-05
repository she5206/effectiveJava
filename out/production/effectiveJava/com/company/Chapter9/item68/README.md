# Item 68 遵守普遍的命名規則

* 命名規則大致上可以分為兩類：字面的(typographical)和語法的(grammatical)
* 違反會造成其他程式設計師的難以維護和困擾

### 字面的
* package:
  * 使用句號(.)分隔每個部分
  * 每個部分包括小寫英文和數字(數字較少使用)
  * 網域及組織名稱在開頭, ex: edu.cmu, com.yahoo, gov.nsa
  * 名稱不能以java 或 javax 開頭

* components:
  * 一或多個component 組成package名稱
  * 精簡, 少於8個字元
  * 使用有意義的縮寫, ex: (O) util  (X) utilities
  * 首字母的縮寫也是可以接受的, ex: awt (Abstract Window Toolkit)
  * 每個部分以一個單字或一個縮寫組成
  * 可以適當的用來做分層, ex: javax.util 用多層 java.util.concurrent.atomic 作為 subpackages

* class/interface:
  * 字首大寫, ex: FutureTask
  * 盡量避免使用縮寫
  * 如果使用縮寫, 推薦還是字首大寫
    * HTTPURL v.s. HttpUrl (哪個好看呢?)

* method/field:
  * 字首小寫, ex: remove or ensureCapacity

* constant fields:
  * 全大寫, 用底線隔開, ex: VALUES or NEGATIVE_INFINITY

* local variables:
  * 字首小寫, ex: i, denom, houseNum
  * 允許使用縮寫


* Type parameter
  * 通常是單一字母
    * T for an arbitrary type
    * E for the element type of a collection
    * K and V for the key and value types of a map
    * X for an exception
    * R for the return type of a function
    * A sequence of arbitrary types can be T, U, V or T1, T2, T3.


### 語法上的
* 文法命名
  * class name, enum: 通常是名詞, ex: Thread, PriorityQueue, or ChessPiece
  * utility classes: 通常是複數名詞, ex: Collectors or Collections
  * interfaces: 可以是名詞, 或是 -able 和 -ible 結尾, ex: Runnable, Iterable, or Accessible
  * annotation types: 則是名詞, 動詞, 形容詞都有人使用, ex: BindingAnnotation, Inject, ImplementedBy, or Singleton.
  * method:
    * 通常是動詞, ex: append or drawImage
    * 回傳值是boolean的方法, 通常是 is 或 has 開頭搭配名詞或形容詞, ex: isEmpty or hasSiblings.
    * 回傳值非boolean的方法, 通常是名詞或動詞, ex: size, hashCode, or getTime

        不見得要get開頭, 如此也很好讀：
        ```
        if (car.speed() > 2 * SPEED_LIMIT)

            generateAudibleAlert("Watch out for cops!");
        ```
    * 如果是在Bean裡面, 則遵守getAttribute or setAttribute
    * 轉換對象的方法, 用toType, ex: toString or toArray
    * 返回view的方法, 用asType, ex: asList
    * 返回基本類型的方法, 用typeValue, ex: intValue
    * 靜態工廠方法通常用of, getInstance, newInstance

* 結論: 把標準的命名規範當內規, 並學著用它們作為第二特性
如果長期習慣養成的習慣與此不同, 請不要盲目遵守命名規範, 請運用常識

