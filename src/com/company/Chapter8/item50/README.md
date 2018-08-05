# Item 50: 必要時進行保護性拷貝

* Java 是一種安全語言（safe language), 表示他免疫於buffer overruns, array overruns, wild pointers, and other memory corruption
* 還是必須做適當的保護, 預防clients做惡意破壞

## 時間週期範例1

* 聲稱是"不可變"的時間週期範例:
```
// Broken "immutable" time period class

public final class Period {

    private final Date start;
    private final Date end;

    /**
     * @param  start the beginning of the period
     * @param  end the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end   = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }
    ...    // Remainder omitted
}
```

* Date本身是可變的, 所以有可能會違反start在end之前
```
// Attack the internals of a Period instance

Date start = new Date();

Date end = new Date();

Period p = new Period(start, end);

end.setYear(78);  // Modifies internals of p!
```

* 因此備份參數是必要的
// Repaired constructor - makes defensive copies of parameters

```
public Period(Date start, Date end) {
    this.start = new Date(start.getTime());
    this.end   = new Date(end.getTime());
    if (this.start.compareTo(this.end) > 0){
      throw new IllegalArgumentException(this.start + " after " + this.end);
    }
}
```

* 不建議使用clone去做拷貝, 可能會讓攻擊者自由控制所有instance

## 時間週期範例2

* 改變Period物件
```
// Second attack on the internals of a Period instance
Date start = new Date();
Date end = new Date();
Period p = new Period(start, end);
p.end().setYear(78);  // Modifies internals of p!
```

* 讓start, end也回傳拷貝性
```
// Repaired accessors - make defensive copies of internal fields
public Date start() {
    return new Date(start.getTime());
}

public Date end() {
    return new Date(end.getTime());
}
```


# 結論

* 如果對象有可能之後再被修改, 就要進行保護性拷貝
  * 例如 Map和Set
* 有經驗的程式設計師會用Date.getTime(), 避免上述麻煩
* 保護性拷貝會影響效能, 如果調用方法者和方法, 雙方都是自己人, 自己寫的, 就可以選擇不使用保護性拷貝, 但必須在doc中說明清楚, 不得修改其內容
* 簡單說:
  * 類別有可能得到或者返回可變物件, 類別就必須對物件進行保護拷貝
  * 因為成本考量, 並且信任client不會不洽當的修改物件, 則可以在doc中說明client的職責是不得修改受到影響的物件, 代替保護拷貝


