package com.company.Chapter9.item63.example1;

public class Example1 {

    public static void main(String[] args){
        String result = "";

        System.out.println(result + "a" + "b");
        long startTs = System.currentTimeMillis();
        for (int i = 0; i < numItems(); i++) {

            result += lineForItem(i);  // 反覆連接字串
        }
        long endTs = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("It costs " + (endTs-startTs) + " milliseconds.");
    }

    public static int numItems(){
        return 100;
    }

    public static String lineForItem(int i) {
        return "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"; // length: 80
    }
}
