package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive unit tests for the Calculator class.
 * Tests cover all public methods including happy path, edge cases, and error conditions.
 *
 * @author Example Team
 * @version 1.0
 */
@DisplayName("Calculator Unit Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {

        @Test
        @DisplayName("Should add two positive numbers correctly")
        void testAddPositiveNumbers() {
            assertEquals(15, calculator.add(10, 5));
        }

        @Test
        @DisplayName("Should add two negative numbers correctly")
        void testAddNegativeNumbers() {
            assertEquals(-15, calculator.add(-10, -5));
        }

        @Test
        @DisplayName("Should return zero when adding zero to zero")
        void testAddZeros() {
            assertEquals(0, calculator.add(0, 0));
        }

        @Test
        @DisplayName("Should handle mixed positive and negative numbers")
        void testAddMixedNumbers() {
            assertEquals(5, calculator.add(10, -5));
            assertEquals(-5, calculator.add(-10, 5));
        }

        @ParameterizedTest
        @CsvSource({
            "1, 1, 2",
            "100, 200, 300",
            "-50, 50, 0",
            "0, 100, 100"
        })
        @DisplayName("Should add various number combinations correctly")
        void testAddParameterized(int first, int second, int expected) {
            assertEquals(expected, calculator.add(first, second));
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {

        @Test
        @DisplayName("Should subtract two positive numbers correctly")
        void testSubtractPositiveNumbers() {
            assertEquals(5, calculator.subtract(10, 5));
        }

        @Test
        @DisplayName("Should handle negative result")
        void testSubtractNegativeResult() {
            assertEquals(-5, calculator.subtract(5, 10));
        }

        @Test
        @DisplayName("Should return zero when subtracting same numbers")
        void testSubtractSameNumbers() {
            assertEquals(0, calculator.subtract(5, 5));
        }

        @ParameterizedTest
        @CsvSource({
            "10, 3, 7",
            "0, 5, -5",
            "-5, -5, 0",
            "100, 50, 50"
        })
        @DisplayName("Should subtract various number combinations correctly")
        void testSubtractParameterized(int minuend, int subtrahend, int expected) {
            assertEquals(expected, calculator.subtract(minuend, subtrahend));
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {

        @Test
        @DisplayName("Should multiply two positive numbers correctly")
        void testMultiplyPositiveNumbers() {
            assertEquals(50, calculator.multiply(10, 5));
        }

        @Test
        @DisplayName("Should return zero when multiplying by zero")
        void testMultiplyByZero() {
            assertEquals(0, calculator.multiply(100, 0));
            assertEquals(0, calculator.multiply(0, 100));
        }

        @Test
        @DisplayName("Should handle negative numbers correctly")
        void testMultiplyNegativeNumbers() {
            assertEquals(-50, calculator.multiply(10, -5));
            assertEquals(50, calculator.multiply(-10, -5));
        }

        @ParameterizedTest
        @CsvSource({
            "3, 4, 12",
            "7, 8, 56",
            "-3, 4, -12",
            "-3, -4, 12"
        })
        @DisplayName("Should multiply various number combinations correctly")
        void testMultiplyParameterized(int first, int second, int expected) {
            assertEquals(expected, calculator.multiply(first, second));
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {

        @Test
        @DisplayName("Should divide two numbers correctly")
        void testDivideNumbers() {
            assertEquals(2.0, calculator.divide(10, 5));
        }

        @Test
        @DisplayName("Should return decimal result for non-exact division")
        void testDivideNonExact() {
            assertEquals(2.5, calculator.divide(5, 2), 0.0001);
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when dividing by zero")
        void testDivideByZero() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
            );
            assertEquals("Cannot divide by zero", exception.getMessage());
        }

        @Test
        @DisplayName("Should handle negative numbers correctly")
        void testDivideNegativeNumbers() {
            assertEquals(-2.0, calculator.divide(10, -5));
            assertEquals(2.0, calculator.divide(-10, -5));
        }

        @ParameterizedTest
        @CsvSource({
            "10, 2, 5.0",
            "15, 3, 5.0",
            "7, 2, 3.5",
            "-10, 2, -5.0"
        })
        @DisplayName("Should divide various number combinations correctly")
        void testDivideParameterized(int dividend, int divisor, double expected) {
            assertEquals(expected, calculator.divide(dividend, divisor), 0.0001);
        }
    }

    @Nested
    @DisplayName("Modulo Tests")
    class ModuloTests {

        @Test
        @DisplayName("Should calculate modulo correctly")
        void testModulo() {
            assertEquals(1, calculator.modulo(10, 3));
        }

        @Test
        @DisplayName("Should return zero when evenly divisible")
        void testModuloEvenlyDivisible() {
            assertEquals(0, calculator.modulo(10, 5));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when modulo by zero")
        void testModuloByZero() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.modulo(10, 0)
            );
            assertEquals("Cannot calculate modulo with zero divisor", exception.getMessage());
        }

        @ParameterizedTest
        @CsvSource({
            "17, 5, 2",
            "10, 3, 1",
            "15, 5, 0",
            "7, 4, 3"
        })
        @DisplayName("Should calculate modulo for various inputs correctly")
        void testModuloParameterized(int dividend, int divisor, int expected) {
            assertEquals(expected, calculator.modulo(dividend, divisor));
        }
    }

    @Nested
    @DisplayName("Power Tests")
    class PowerTests {

        @Test
        @DisplayName("Should calculate power correctly")
        void testPower() {
            assertEquals(8.0, calculator.power(2, 3), 0.0001);
        }

        @Test
        @DisplayName("Should return 1 when exponent is zero")
        void testPowerZeroExponent() {
            assertEquals(1.0, calculator.power(5, 0), 0.0001);
        }

        @Test
        @DisplayName("Should handle negative exponents")
        void testPowerNegativeExponent() {
            assertEquals(0.25, calculator.power(2, -2), 0.0001);
        }

        @ParameterizedTest
        @CsvSource({
            "2, 3, 8.0",
            "5, 2, 25.0",
            "10, 0, 1.0",
            "3, 4, 81.0"
        })
        @DisplayName("Should calculate power for various inputs correctly")
        void testPowerParameterized(int base, int exponent, double expected) {
            assertEquals(expected, calculator.power(base, exponent), 0.0001);
        }
    }

    @Nested
    @DisplayName("Percentage Tests")
    class PercentageTests {

        @Test
        @DisplayName("Should calculate percentage correctly")
        void testCalculatePercentage() {
            assertEquals(500, calculator.calculatePercentage(5));
        }

        @Test
        @DisplayName("Should return zero for zero input")
        void testCalculatePercentageZero() {
            assertEquals(0, calculator.calculatePercentage(0));
        }

        @Test
        @DisplayName("Should handle negative values")
        void testCalculatePercentageNegative() {
            assertEquals(-500, calculator.calculatePercentage(-5));
        }

        @ParameterizedTest
        @CsvSource({
            "1, 100",
            "10, 1000",
            "0, 0",
            "-5, -500"
        })
        @DisplayName("Should calculate percentage for various inputs correctly")
        void testCalculatePercentageParameterized(int value, int expected) {
            assertEquals(expected, calculator.calculatePercentage(value));
        }
    }

    @Nested
    @DisplayName("Square Root Tests")
    class SquareRootTests {

        @Test
        @DisplayName("Should calculate square root correctly")
        void testSquareRoot() {
            assertEquals(5.0, calculator.squareRoot(25), 0.0001);
        }

        @Test
        @DisplayName("Should return zero for zero input")
        void testSquareRootZero() {
            assertEquals(0.0, calculator.squareRoot(0), 0.0001);
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException for negative numbers")
        void testSquareRootNegative() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.squareRoot(-1)
            );
            assertTrue(exception.getMessage().contains("Cannot calculate square root of negative number"));
        }

        @ParameterizedTest
        @CsvSource({
            "4, 2.0",
            "9, 3.0",
            "16, 4.0",
            "100, 10.0"
        })
        @DisplayName("Should calculate square root for various inputs correctly")
        void testSquareRootParameterized(int number, double expected) {
            assertEquals(expected, calculator.squareRoot(number), 0.0001);
        }
    }

    @Nested
    @DisplayName("Absolute Value Tests")
    class AbsoluteValueTests {

        @Test
        @DisplayName("Should return same value for positive numbers")
        void testAbsoluteValuePositive() {
            assertEquals(5, calculator.absoluteValue(5));
        }

        @Test
        @DisplayName("Should return positive value for negative numbers")
        void testAbsoluteValueNegative() {
            assertEquals(5, calculator.absoluteValue(-5));
        }

        @Test
        @DisplayName("Should return zero for zero")
        void testAbsoluteValueZero() {
            assertEquals(0, calculator.absoluteValue(0));
        }

        @ParameterizedTest
        @ValueSource(ints = {-100, -50, -1, 0, 1, 50, 100})
        @DisplayName("Should return non-negative absolute value")
        void testAbsoluteValueNonNegative(int number) {
            assertTrue(calculator.absoluteValue(number) >= 0);
        }
    }

    @Nested
    @DisplayName("Parse Integer Tests")
    class ParseIntegerTests {

        @Test
        @DisplayName("Should parse valid integer string")
        void testParseIntegerValid() {
            assertEquals(123, calculator.parseInteger("123"));
        }

        @Test
        @DisplayName("Should parse negative integer string")
        void testParseIntegerNegative() {
            assertEquals(-456, calculator.parseInteger("-456"));
        }

        @Test
        @DisplayName("Should return default value for null input")
        void testParseIntegerNull() {
            assertEquals(0, calculator.parseInteger(null));
        }

        @Test
        @DisplayName("Should return default value for empty string")
        void testParseIntegerEmpty() {
            assertEquals(0, calculator.parseInteger(""));
        }

        @Test
        @DisplayName("Should return default value for whitespace only")
        void testParseIntegerWhitespace() {
            assertEquals(0, calculator.parseInteger("   "));
        }

        @Test
        @DisplayName("Should return default value for invalid string")
        void testParseIntegerInvalid() {
            assertEquals(0, calculator.parseInteger("abc"));
        }

        @Test
        @DisplayName("Should handle string with leading/trailing spaces")
        void testParseIntegerWithSpaces() {
            assertEquals(42, calculator.parseInteger("  42  "));
        }

        @ParameterizedTest
        @CsvSource({
            "100, 100",
            "-50, -50",
            "0, 0",
            "999, 999"
        })
        @DisplayName("Should parse various valid integer strings correctly")
        void testParseIntegerParameterized(String input, int expected) {
            assertEquals(expected, calculator.parseInteger(input));
        }
    }

    @Nested
    @DisplayName("Log Result Tests")
    class LogResultTests {

        @Test
        @DisplayName("Should not throw exception when logging result")
        void testLogResultDoesNotThrow() {
            assertDoesNotThrow(() -> calculator.logResult(42));
        }

        @Test
        @DisplayName("Should handle negative result")
        void testLogResultNegative() {
            assertDoesNotThrow(() -> calculator.logResult(-100));
        }

        @Test
        @DisplayName("Should handle zero result")
        void testLogResultZero() {
            assertDoesNotThrow(() -> calculator.logResult(0));
        }
    }
}
