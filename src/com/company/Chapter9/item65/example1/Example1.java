package com.company.Chapter9.item65.example1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class MyMenu extends TreeSet<String> {
    public MyMenu() {

    }
}

public class Example1 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String[] input = {"com.company.Chapter9.item65.example1.MyMenu", "string1", "string2", "string3", "string4"};
        // Translate the class name into a Class object
        Class<? extends Set<String>> cl = null;
        try {

            cl = (Class<? extends Set<String>>)  // Unchecked cast!
                    Class.forName(input[0]);
        } catch (ClassNotFoundException e) {
            fatalError("Class not found.");
        }
        // Get the constructor
        Constructor<? extends Set<String>> cons = null;
        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("No parameterless constructor");
        }
        // Instantiate the set
        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (IllegalAccessException e) {
            fatalError("Constructor not accessible");
        } catch (InstantiationException e) {
            fatalError("Class not instantiable.");
        } catch (InvocationTargetException e) {
            fatalError("Constructor threw " + e.getCause());
        } catch (ClassCastException e) {
            fatalError("Class doesn't implement Set");
        }
        // Exercise the set
        List list = Arrays.asList(input).subList(1, input.length);
        s.addAll(list);
        for (String ss : s) {
            System.out.println(ss);
        }
    }

    private static void fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);
    }
}
