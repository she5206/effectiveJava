# Item 54: 回傳零長度的Collection或arrays, 非null


下面的方法很常見：

```
// Returns null to indicate an empty collection. Don't do this!

private final List<Cheese> cheesesInStock = ...;

/**
 * @return a list containing all of the cheeses in the shop,
 *     or null if no cheeses are available for purchase.
 */
public List<Cheese> getCheeses() {
    return cheesesInStock.isEmpty() ? null
        : new ArrayList<>(cheesesInStock);
}
```

這樣做會要求使用端必須有額外的程式碼驗證null
```
List<Cheese> cheeses = shop.getCheeses();
if (cheeses != null && cheeses.contains(Cheese.STILTON))
    System.out.println("Jolly good, just the thing.");
```

而非
```
List<Cheese> cheeses = shop.getCheeses();
if (cheeses.contains(Cheese.STILTON))
    System.out.println("Jolly good, just the thing.");
```

客戶端如果忘了處理, 可能這樣的錯誤一直都不會被人發現

認為null比較好的原因

1. 擔心性能問題, 因為new物件有多餘開銷(作者說不需要在此刻當心, 除非method是效能的真正源頭）
2. 零長度的array可能每次都會發生, 零長度array不可變, 不可變對象可以被自由共享(但實際上, 標準做法)

```

```

