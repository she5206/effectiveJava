package com.company.Chapter6.item39.example1;

// Marker annotation type declaration

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated method is a test method.
 * Use only on parameterless static methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)             // 在方法聲明才合法
public @interface Test {
}

/**
 * 命名模式的缺點
 * 缺點1: 拼字錯誤不會提示, eg testSafetyOverride,  tsetSafetyOverride
 * 缺點2: class TestSafetyMechanisms in hopes that JUnit 3 would automatically test all of its methods, regardless of their names.
 * Again, JUnit 3 wouldn’t complain, but it wouldn’t execute the tests either.
 * 缺點3: 參數和程式變數沒有很好的關聯, 例如想要驗證拋出某種例外錯誤, 編譯器不會檢查, 要等到執行後才會知道結果
 **/