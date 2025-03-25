package com.github.javabaz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Calculator42Test {


    private Calculator42 calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator42();
    }

    @Test
    void testAddition() {
        assertEquals(8, calculator.add(5, 3), "5 + 3 should be 8");
        assertEquals(-2, calculator.add(-5, 3), "-5 + 3 should be -2");
        assertEquals(0, calculator.add(0, 0), "0 + 0 should be 0");
    }

    @Test
    void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3), "5 - 3 should be 2");
        assertEquals(-8, calculator.subtract(-5, 3), "-5 - 3 should be -8");
        assertEquals(0, calculator.subtract(3, 3), "3 - 3 should be 0");
    }

    @Test
    void testMultiplication() {
        assertEquals(15, calculator.multiply(5, 3), "5 * 3 should be 15");
        assertEquals(-15, calculator.multiply(-5, 3), "-5 * 3 should be -15");
        assertEquals(0, calculator.multiply(0, 3), "0 * 3 should be 0");
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should be 2");
        assertEquals(-2, calculator.divide(-6, 3), "-6 / 3 should be -2");
        assertEquals(0, calculator.divide(0, 5), "0 / 5 should be 0");
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testPower() {
        assertEquals(9, calculator.pow(3, 2), "3 ^ 2 should be 9");
        assertEquals(1, calculator.pow(3, 0), "3 ^ 0 should be 1");
        assertEquals(0, calculator.pow(0, 2), "0 ^ 2 should be 0");
    }

    @Test
    void testNegativeExponent() {
        assertEquals(0.125, calculator.pow(2, -3), "2 ^ -3 should be 0.125");
        assertEquals(1.0 / 27, calculator.pow(3, -3), "3 ^ -3 should be 1/27");
    }

    @Test
    void testUndefinedZeroPowerZero() {
        Exception exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.pow(0, 0),
                "0 ^ 0 should throw an ArithmeticException"
        );
        assertEquals("0 ^ 0 is undefined", exception.getMessage());
    }


    @Test
    void testModulusWhenBothNumbersHaveSameSign() {
        assertEquals(1, calculator.mod(10, 3), "10 % 3 should be 1");
        assertEquals(0, calculator.mod(12, 4), "12 % 4 should be 0");
        assertEquals(-1, calculator.mod(-10, -3), "-10 % -3 should be -1");
        assertEquals(-2, calculator.mod(-8, -3), "-8 % -3 should be -2");
    }

    @Test
    void testModulusWithNegativeDividend() {
        assertEquals(-1, calculator.mod(-10, 3), "-10 % 3 should be -1");
        assertEquals(-2, calculator.mod(-8, 3), "-8 % 3 should be -2");
    }

    @Test
    void testModulusWithNegativeDivisor() {
        assertEquals(1, calculator.mod(10, -3), "10 % -3 should be 1");
        assertEquals(2, calculator.mod(8, -3), "8 % -3 should be 2");
    }


    @Test
    void testSqrtOfNegativeNumbers() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> calculator.sqrt(-25),
                "Negative numbers should throw an exception"
        );
        assertEquals("Negative numbers don't have real square roots!", exception.getMessage());
    }

    @Test
    void testPerfectSqrt() {
        assertEquals(5.00, calculator.sqrt(25), "Square root of 25 should be 5");
        assertEquals(10.00, calculator.sqrt(100), "Square root of 100 should be 10");
        assertEquals(1.00, calculator.sqrt(1), "Square root of 1 should be 1");
        assertEquals(0.00, calculator.sqrt(0), "Square root of 0 should be 0");
    }

    @Test
    void testNonPerfectSqrt() {
        assertEquals(4, (int) calculator.sqrt(20), "Square root of 20 should be 4 (integer part only)");
        assertEquals(3, (int) calculator.sqrt(15), "Square root of 15 should be 3 (integer part only)");
        assertEquals(6, (int) calculator.sqrt(40), "Square root of 40 should be 6 (integer part only)");
    }
}


