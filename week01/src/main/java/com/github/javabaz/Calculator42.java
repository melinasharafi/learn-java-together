package com.github.javabaz;

public class Calculator42 {


    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {

        // Division by zero is not allowed
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public double pow(int a, int b) {

        // 0 ^ 0 is undefined
        if (a == 0 && b == 0) {
            throw new ArithmeticException("0 ^ 0 is undefined");
        }

        // Check if the exponent (b) is negative
        boolean bIsNegative = b < 0;
        b = Math.abs(b);

        // Every number raised to the power of 0 is equal to 1.
        double result = 1;

        for (int i = 0; i < b; i++) {
            result *= a;
        }

        // If the original exponent was negative, return the reciprocal
        if (bIsNegative) {
            return 1.0 / result;
        }

        return result;
    }

    public int mod(int a, int b) {

        // Without using % operator
        int remainder = a - (b * (a / b));

        // Adjust remainder to match Java's % behavior.
        // a and reminder should have same sign
        if (remainder < 0 && a > 0 || remainder > 0 && a < 0) {
            return remainder + b;
        }

        return remainder;
    }

    public double sqrt(int a) {

        if (a < 0) {
            throw new ArithmeticException("Negative numbers don't have real square roots!");
        }

        // using Newton algorithm
        double root = a;
        double precision = 0.001;

        while (Math.abs(root * root - a) > precision) {

            root = (root + a / root) / 2;
        }

        return Math.round(root * 100.0) / 100.0;

    }

}

