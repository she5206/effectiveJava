package com.company.Chapter9.item63.example2;


public class Example2 {
    public static void main(String[] args) {
        StringBuilder b = new StringBuilder(numItems() * 80);
        long startTs = System.currentTimeMillis();
        for (int i = 0; i < numItems(); i++) {
            b.append(lineForItem(i));
        }
        long endTs = System.currentTimeMillis();
        System.out.println(b.toString());
        System.out.println("It costs " + (endTs - startTs) + " milliseconds.");
    }

    public static int numItems() {
        return 100;
    }

    public static String lineForItem(int i) {
        return "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"; // legnth: 80
    }
}
