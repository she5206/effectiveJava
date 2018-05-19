package com.company.Chapter7.item42.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example1_2 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("abc");
        words.add("b");
        System.out.println(words);

        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(words);
    }
}

/**
 * The types of the lambda (Comparator<String>), of its parameters (s1 and s2, both String),
 * and of its return value (int) are not present in the code.
 * The compiler deduces these types from context, using a process known as "type inference"
 * Omit the types of all lambda parameters unless their presence makes your program clearer
 */
