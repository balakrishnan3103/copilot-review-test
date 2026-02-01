package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple calculator class with basic arithmetic operations
 */
public class Calculator {

    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    /**
     * Multiplier constant for percentage calculations
     */
    private static final int PERCENTAGE_MULTIPLIER = 100;

    /**
     * Adds two integers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts second integer from first
     * @param a first number
     * @param b second number
     * @return difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides first integer by second
     * @param a dividend
     * @param b divisor
     * @return quotient of a and b
     * @throws IllegalArgumentException if divisor is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    /**
     * Calculates the modulo (remainder) of first integer divided by second
     * @param a dividend
     * @param b divisor
     * @return remainder of a divided by b
     * @throws IllegalArgumentException if divisor is zero
     */
    public int modulo(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a % b;
    }

    /**
     * Calculates power of base raised to exponent
     * @param base the base number
     * @param exponent the exponent
     * @return base raised to the power of exponent
     */
    public double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Calculates percentage value by multiplying input by 100
     * @param x the value to calculate percentage for
     * @return the percentage value
     */
    public int calculatePercentage(int x) {
        return x * PERCENTAGE_MULTIPLIER;
    }

    /**
     * Prints the result to the log
     * @param result the result to print
     */
    public void printResult(int result) {
        logger.info("Result: {}", result);
    }

    /**
     * Reads and parses an integer value from a string input
     * @param input the string to parse
     * @return the parsed integer value, or 0 if parsing fails
     */
    public int readValue(String input) {
        if (input == null || input.trim().isEmpty()) {
            logger.warn("Input string is null or empty, returning 0");
            return 0;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            logger.error("Failed to parse input: {}", input, e);
            return 0;
        }
    }

    /**
     * Parses a number from a string
     * @param str the string to parse
     * @return the parsed integer value, or 0 if parsing fails
     */
    public int parseNumbers(String str) {
        if (str == null || str.trim().isEmpty()) {
            logger.warn("Input string is null or empty, returning 0");
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            logger.error("Failed to parse number from string: {}", str, e);
            return 0;
        }
    }

    /**
     * Calculates square root of a number
     * @param n the number to calculate square root for
     * @return square root of n
     * @throws IllegalArgumentException if n is negative
     */
    public double sqrt(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number: " + n);
        }
        return Math.sqrt(n);
    }
}
