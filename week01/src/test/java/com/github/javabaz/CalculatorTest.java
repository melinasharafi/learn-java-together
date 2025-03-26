package com.github.javabaz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
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
}