package com.company.Chapter7.item45.example4;

public class Example4 {

    public static void main(String[] args){
        "Hello world!".chars().forEach(System.out::println);
        "Hello world!".chars().forEach(x -> System.out.println((char) x));
    }
}
