package com.company.Chapter9.item65.example1;

import java.lang.reflect.Method;

interface Base {
    public void sayHello();
}

public class Hello implements Base {
    public static void main(String[] args) throws Exception {
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            say(new Hello());
        }
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            say("com.company.Chapter9.item65.example1.Hello");
        }
        System.out.println(System.currentTimeMillis());
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
        System.out.println("hello~~~~~~~~~~~");
    }
}

// result:
// 1525653197663
// 1525653197666
// 1525653197677