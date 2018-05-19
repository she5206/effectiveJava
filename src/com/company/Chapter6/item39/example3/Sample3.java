package com.company.Chapter6.item39.example3;

// Program containing annotations with a parameter

import java.util.ArrayList;
import java.util.List;

public class Sample3 {
    // Code containning an annotation with an array parameter
    @ExceptionTest({IndexOutOfBoundsException.class,
            NullPointerException.class})
    public static void doublyBad() {
        List<String> list = new ArrayList<String>();

        // The spec permits this method to throw either
        // IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }
}