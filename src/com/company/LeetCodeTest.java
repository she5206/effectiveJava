package com.company;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

public class LeetCodeTest {
    public static void main(String[] args) {
        System.out.println(test(-1534236469));
    }

    public static int test(int x) {
        String temp = Integer.toString(abs(x));
        int[] nums = new int[temp.length()];
        StringBuilder strNum = new StringBuilder();
        int input = x;
        int result = 0;

        for (int num : nums) {
            result = input % 10;
            input = input / 10;
            strNum.append(result);
        }

        int r = Integer.parseInt(strNum.toString());
        if (x < 0) {
            r = r * -1;
        }
        return r;
    }
}

// 0 1 2 3 4
// 9 8 7 6 5
