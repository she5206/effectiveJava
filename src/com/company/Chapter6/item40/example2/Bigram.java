package com.company.Chapter6.item40.example2;

import java.util.HashSet;
import java.util.Set;

// Can you spot the bug?

public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<Bigram>();
        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));
        System.out.println(s.size());
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Bigram))
            return false;
        Bigram b = (Bigram) o;
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }
}

/*
In summary, the compiler can protect you from a great many errors
if you use the Override annotation on every method declaration
that you believe to override a supertype declaration, with one exception.
In concrete classes, you need not annotate methods
that you believe to override abstract method declarations
* */