package com.company.Chapter7.item43.example1;

import java.util.HashMap;
import java.util.Map;

public class Example1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Emily", 1);
        map.put("Dan", 2);
        map.put("Roger", 3);

        map.forEach((k, v) ->
                map.merge(k, 1, (count, incr) -> count + incr));

        System.out.println(map);
    }
}
