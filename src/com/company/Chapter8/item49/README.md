# Item 49: Check parameters for validity

本日原則：應該在發生錯誤之後儘快檢查出錯誤！

* 沒有檢查參數, 可能會發生:
  * 運氣好, 方法處理失敗, 丟出異常
  * 運氣差一點, 可以正常return, 回傳錯誤的值
  * 更差, 正常回傳, 但回傳的值讓其他對象在不確定的時候爆炸！引發不相關的錯誤！


* 使用 Javadoc @throws 標註例外
```
/**

 * Returns a BigInteger whose value is (this mod m). This method

 * differs from the remainder method in that it always returns a

 * non-negative BigInteger.

 *

 * @param m the modulus, which must be positive

 * @return this mod m

 * @throws ArithmeticException if m is less than or equal to 0

 */

public BigInteger mod(BigInteger m) {

    if (m.signum() <= 0)

        throw new ArithmeticException("Modulus <= 0: " + m);

    ... // Do the computation

}
```

* 不標示 “mod throws NullPointerException if m is null“
* @Nullable 也不是一個標記null的好方法
* Java 7之後支援Objects.requireNonNull, 再也不用做null check!

```
// Inline use of Java's null-checking facility

this.strategy = Objects.requireNonNull(strategy, "strategy");

public static <T> T requireNonNull(T obj, String message) {
    if (obj == null)
        throw new NullPointerException(message);
    return obj;
}
```

* Java 9, range-checking facility: checkFromIndexSize, checkFromToIndex, and checkIndex

* 用assert確認input, assert失敗會throw AssertionError, 範例:

```
// Private helper function for a recursive sort

private static void sort(long a[], int offset, int length) {

    assert a != null;

    assert offset >= 0 && offset <= a.length;

    assert length >= 0 && length <= a.length - offset;

    ... // Do the computation

}
```

* 檢查保存起來以後使用的參數尤其重要, 輸入int, 輸出List, 如果省略null check, 一旦其他人使用了這個List, 會拋出NullPointException, 想找到實例化List的地方就會比較困難

* 簡言之, 寫方法要注意她的參數有哪些限制, 應該寫入Javadoc中, 只要能檢查出任何一個錯誤, 你所寫的檢查就是值得的！
