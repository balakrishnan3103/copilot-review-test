package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Calculator class
 */
@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test addition of two positive numbers")
    void testAdd() {
        assertEquals(8, calculator.add(5, 3));
        assertEquals(0, calculator.add(0, 0));
        assertEquals(100, calculator.add(50, 50));
    }

    @Test
    @DisplayName("Test subtraction of two numbers")
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(0, calculator.subtract(5, 5));
        assertEquals(-5, calculator.subtract(0, 5));
    }

    @Test
    @DisplayName("Test multiplication of two numbers")
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-15, calculator.multiply(5, -3));
    }

    @Test
    @DisplayName("Test division of two numbers")
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(-2.0, calculator.divide(6, -3));
    }

    @Test
    @DisplayName("Test division by zero throws exception")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
    }
}
