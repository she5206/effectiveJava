package com.company.Chapter6.item39.example2;

// Annotation type with a parameter
import java.lang.annotation.*;
/**
 * Indicates that the annotated method is a test method that
 * must throw the designated exception to succeed.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class<? extends Exception> value();
}

/**
 * 驗證拋出異常才算成功的測試
 * 多Class<? extends Exception>
 */