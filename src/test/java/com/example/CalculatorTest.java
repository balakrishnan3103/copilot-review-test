package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    void testAddPositiveNumbers() {
        assertEquals(100, calculator.add(50, 50));
    }

    @Test
    @DisplayName("Test addition with zero")
    void testAddWithZero() {
        assertEquals(0, calculator.add(0, 0));
        assertEquals(5, calculator.add(5, 0));
        assertEquals(5, calculator.add(0, 5));
    }

    @Test
    @DisplayName("Test addition with negative numbers")
    void testAddNegativeNumbers() {
        assertEquals(-10, calculator.add(-5, -5));
        assertEquals(0, calculator.add(5, -5));
    }

    @Test
    @DisplayName("Test subtraction of two numbers")
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(0, calculator.subtract(5, 5));
        assertEquals(-5, calculator.subtract(0, 5));
    }

    @Test
    @DisplayName("Test subtraction with negative numbers")
    void testSubtractNegativeNumbers() {
        assertEquals(10, calculator.subtract(5, -5));
        assertEquals(-10, calculator.subtract(-5, 5));
    }

    @Test
    @DisplayName("Test multiplication of two numbers")
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-15, calculator.multiply(5, -3));
    }

    @Test
    @DisplayName("Test multiplication with negative numbers")
    void testMultiplyNegativeNumbers() {
        assertEquals(25, calculator.multiply(-5, -5));
        assertEquals(0, calculator.multiply(0, 100));
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
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Test modulo operation")
    void testModulo() {
        assertEquals(1, calculator.modulo(10, 3));
        assertEquals(0, calculator.modulo(10, 5));
        assertEquals(2, calculator.modulo(17, 5));
    }

    @Test
    @DisplayName("Test modulo by zero throws exception")
    void testModuloByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.modulo(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 8.0",
        "5, 2, 25.0",
        "10, 0, 1.0",
        "2, -2, 0.25"
    })
    @DisplayName("Test power calculation with various inputs")
    void testPower(int base, int exponent, double expected) {
        assertEquals(expected, calculator.power(base, exponent), 0.0001);
    }

    @Test
    @DisplayName("Test percentage calculation")
    void testCalculatePercentage() {
        assertEquals(100, calculator.calculatePercentage(1));
        assertEquals(500, calculator.calculatePercentage(5));
        assertEquals(0, calculator.calculatePercentage(0));
        assertEquals(-100, calculator.calculatePercentage(-1));
    }

    @Test
    @DisplayName("Test readValue with valid input")
    void testReadValueValidInput() {
        assertEquals(123, calculator.readValue("123"));
        assertEquals(-456, calculator.readValue("-456"));
        assertEquals(0, calculator.readValue("0"));
    }

    @Test
    @DisplayName("Test readValue with invalid input")
    void testReadValueInvalidInput() {
        assertEquals(0, calculator.readValue("abc"));
        assertEquals(0, calculator.readValue("12.34"));
        assertEquals(0, calculator.readValue(""));
        assertEquals(0, calculator.readValue(null));
    }

    @Test
    @DisplayName("Test parseNumbers with valid input")
    void testParseNumbersValidInput() {
        assertEquals(789, calculator.parseNumbers("789"));
        assertEquals(-100, calculator.parseNumbers("-100"));
    }

    @Test
    @DisplayName("Test parseNumbers with invalid input")
    void testParseNumbersInvalidInput() {
        assertEquals(0, calculator.parseNumbers("xyz"));
        assertEquals(0, calculator.parseNumbers(""));
        assertEquals(0, calculator.parseNumbers(null));
    }

    @Test
    @DisplayName("Test square root with positive numbers")
    void testSqrtPositiveNumbers() {
        assertEquals(0.0, calculator.sqrt(0), 0.0001);
        assertEquals(1.0, calculator.sqrt(1), 0.0001);
        assertEquals(2.0, calculator.sqrt(4), 0.0001);
        assertEquals(3.0, calculator.sqrt(9), 0.0001);
        assertEquals(10.0, calculator.sqrt(100), 0.0001);
    }

    @Test
    @DisplayName("Test square root with negative number throws exception")
    void testSqrtNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sqrt(-1);
        });
        assertTrue(exception.getMessage().contains("Cannot calculate square root of negative number"));
    }

    @Test
    @DisplayName("Test printResult does not throw exception")
    void testPrintResult() {
        assertDoesNotThrow(() -> calculator.printResult(42));
    }
}
