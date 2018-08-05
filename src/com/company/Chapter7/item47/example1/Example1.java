package com.company.Chapter7.item47.example1;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class Example1 {
    public static void main(String[] args) {
        // 1.1 Won't compile, due to limitations on Java's type inference

//        for (ProcessHandle ph : ProcessHandle.allProcesses()::iterator) {
//
//            // Process the process
//
//        }

        // 1.2 Hideous workaround to iterate over a stream

//        for (ProcessHandle ph : (Iterable<ProcessHandle>) ProcessHandle.allProcesses()::iterator) {

            // Process the process

//        }

        // 1.3 Adapter from  Stream<E> to Iterable<E>
//        for (ProcessHandle p : iterableOf(ProcessHandle.allProcesses())) {

            // Process the process

//        }


    }

    // Adapter from  Stream<E> to Iterable<E>

    public static <E> Iterable<E> iterableOf(Stream<E> stream) {

        return stream::iterator;
    }

    // Adapter from Iterable<E> to Stream<E>

    public static <E> Stream<E> streamOf(Iterable<E> iterable) {

        return StreamSupport.stream(iterable.spliterator(), false);

    }
}
