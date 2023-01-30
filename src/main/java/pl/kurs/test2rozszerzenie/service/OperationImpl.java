package pl.kurs.test2rozszerzenie.service;

import pl.kurs.test2rozszerzenie.exception.UnknownOperatorException;

import java.util.Arrays;


public enum OperationImpl implements Operation{
    ADD('+') {
        @Override
        public double operation(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT('-') {
        @Override
        public double operation(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY('*') {
        @Override
        public double operation(double a, double b) {
            return a * b;
        }
    },
    DIVIDE('/') {
        @Override
        public double operation(double a, double b) {
            return a / b;
        }
    };

    public final char symbol;

    OperationImpl(char symbol) {
        this.symbol = symbol;
    }


    public static OperationImpl getOperator(char symbol) {
        for (OperationImpl op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new UnknownOperatorException("Unknown operator symbol: " + symbol);
    }

    public static boolean isOperator(char operator) {
        return Arrays.stream(values()).anyMatch(o -> o.symbol == operator);
    }



}
