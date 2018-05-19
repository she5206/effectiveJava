package com.company.Chapter7.item46.example1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Example1 {
    public static void main(String[] args){
        System.out.println("here");
    }

//    private void sample1(){
//        // Uses the streams API but not the paradigm--Don't do this!
//        Map<String, Long> freq = new HashMap<>();
//        try (Stream<String> words = new Scanner(file).tokens()) {
//            words.forEach(word -> {
//                freq.merge(word.toLowerCase(), 1L, Long::sum);
//            });
//        }
//    }
//    private void sample2(){
//        // Proper use of streams to initialize a frequency table
//        Map<String, Long> freq;
//        try (Stream<String> words = new Scanner(file).tokens()) {
//            freq = words
//                    .collect(groupingBy(String::toLowerCase, counting()));
//
//        }
//    }
}
