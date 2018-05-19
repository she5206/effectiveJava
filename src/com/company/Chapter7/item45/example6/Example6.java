package com.company.Chapter7.item45.example6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Example6 {
    public static void main(String[] args) {

    }

    // Iterative Cartesian product computation
    private static List<Card> newDeck() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                result.add(new Card(suit, rank));
        return result;
    }

    // Stream-based Cartesian product computation
    private static List<Card> newDeck2() {
        return Stream.of(Suit.values())
                .flatMap(suit ->
                        Stream.of(Rank.values())
                                .map(rank -> new Card(suit, rank)))
                .collect(toList());
    }

    static class Card {
        Card(Object suit, Rank rank) {
        }
    }

    static class Suit {
        static Suit[] values() {
            return null;
        }
    }

    static class Rank {
        static Rank[] values() {
            return null;
        }
    }
}


// If you’re not sure which version you prefer, the iterative version is probably the safer choice.
// If you prefer the stream version and you believe that other programmers who will work with the code will share your preference,
// then you should use it.