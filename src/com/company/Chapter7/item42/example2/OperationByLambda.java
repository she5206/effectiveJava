package com.company.Chapter7.item42.example2;

import java.util.function.DoubleBinaryOperator;

// Enum with function object fields & constant-specific behavior
public enum OperationByLambda {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);
    private final String symbol;
    private final DoubleBinaryOperator op;

    OperationByLambda(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

}

/**
 * using the DoubleBinaryOperator interface for the lambdas that represent the enum constant’s behavior.
 * represents a function that takes two double arguments and returns a double result.
 * */