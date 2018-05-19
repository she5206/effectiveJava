package com.company.Chapter7.item42.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example1_3 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("abc");
        words.add("b");
        System.out.println(words);

        Collections.sort(words, Comparator.comparingInt(str -> str.length()));

        System.out.println(words);
    }
}

/**
 * words.sort(Comparator.comparingInt(String::length));
 */