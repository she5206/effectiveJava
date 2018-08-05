package com.company.Chapter7.item48.example1;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

public class Example1 {
    // Stream-based program to generate the first 20 Mersenne primes

    public static void main(String[] args) {

//        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        primes().map(p -> ONE.pow(p.intValueExact()).subtract(ONE))

                .filter(mersenne -> mersenne.isProbablePrime(50))

                .limit(20)

                .forEach(System.out::println);

    }



    static Stream<BigInteger> primes() {
//        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
        return Stream.iterate(ONE, BigInteger::nextProbablePrime);

    }
}
