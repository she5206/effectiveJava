package com.company.Chapter6.item38.example3;

import java.util.Arrays;
import java.util.Collection;

public class Example3_2 {
    public static void main(String[] args) {
        double x = 10.0;    // Double.parseDouble(args[0]);
        double y = 5.0;     // Double.parseDouble(args[1]);
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
