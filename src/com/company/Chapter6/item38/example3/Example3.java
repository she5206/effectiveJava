package com.company.Chapter6.item38.example3;

public class Example3 {
    public static void main(String[] args) {
        double x = 10.0;    //Double.parseDouble(args[0]);
        double y = 5.0;     //Double.parseDouble(args[1]);
        test(ExtendedOperation.class, x, y);
    }

    // <T extends Enum<T> & Operation> => 確保是列舉, Operation子類別
    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}

