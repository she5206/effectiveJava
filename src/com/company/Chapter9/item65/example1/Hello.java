package com.company.Chapter9.item65.example1;

import java.lang.reflect.Method;

interface Base {
    public void sayHello();
}

public class Hello implements Base {
    public static void main(String[] args) throws Exception {
        // 直接 new 物件
        long startTs1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            say(new Hello());
        }
        long endTs1 = System.currentTimeMillis();
        System.out.println("");
        System.out.println("For normal class, it costs:" + (endTs1 - startTs1));

        // 使用 reflection
        long startTs2 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            say("com.company.Chapter9.item65.example1.Hello");
        }
        long endTs2 = System.currentTimeMillis();
        System.out.println("");
        System.out.println("For reflection class, it costs:" + (endTs2 - startTs2));
    }

    /**
     * 使用物件
     *
     * @param hello
     */
    private static void say(Base hello) {
        hello.sayHello();
    }

    /**
     * 使用reflection
     *
     * @param className
     * @throws Exception
     */
    private static void say(String className) throws Exception {
        Class cl = Class.forName(className);
        Object obj = cl.newInstance();
        Method m = cl.getMethod("sayHello");

        if (m != null) {
            m.invoke(obj);  // function call
        }
    }

    @Override
    public void sayHello() {
        System.out.print("hello~~~~~~~~~~~");
    }
}

// result:
// 1525653197663
// 1525653197666
// 1525653197677