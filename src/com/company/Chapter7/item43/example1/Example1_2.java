package com.company.Chapter7.item43.example1;

import java.util.HashMap;
import java.util.Map;

public class Example1_2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Emily", 1);
        map.put("Dan", 2);
        map.put("Roger", 3);

        map.forEach((k, v) ->
                map.merge(k, 1, Integer::sum));

        System.out.println(map);
    }
}

// method references usually result in shorter, clearer code.
// if a lambda gets too complex, You can extract the code from the lambda into a new method
