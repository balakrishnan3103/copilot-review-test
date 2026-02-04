package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple calculator class that provides basic arithmetic operations.
 * This class follows clean code principles and handles edge cases appropriately.
 *
 * @author Example Team
 * @version 1.0
 */
public class Calculator {

    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    /**
     * Multiplier constant for percentage calculations.
     */
    private static final int PERCENTAGE_MULTIPLIER = 100;

    /**
     * Default value returned when parsing fails.
     */
    private static final int DEFAULT_PARSE_VALUE = 0;

    /**
     * Adds two integers and returns the sum.
     *
     * @param firstNumber the first number to add
     * @param secondNumber the second number to add
     * @return the sum of firstNumber and secondNumber
     */
    public int add(int firstNumber, int secondNumber) {
        logger.debug("Adding {} + {}", firstNumber, secondNumber);
        return firstNumber + secondNumber;
    }

    /**
     * Subtracts the second integer from the first and returns the difference.
     *
     * @param minuend the number to subtract from
     * @param subtrahend the number to subtract
     * @return the difference between minuend and subtrahend
     */
    public int subtract(int minuend, int subtrahend) {
        logger.debug("Subtracting {} - {}", minuend, subtrahend);
        return minuend - subtrahend;
    }

    /**
     * Multiplies two integers and returns the product.
     *
     * @param firstFactor the first factor
     * @param secondFactor the second factor
     * @return the product of firstFactor and secondFactor
     */
    public int multiply(int firstFactor, int secondFactor) {
        logger.debug("Multiplying {} * {}", firstFactor, secondFactor);
        return firstFactor * secondFactor;
    }

    /**
     * Divides the first integer by the second and returns the quotient.
     *
     * @param dividend the number to be divided
     * @param divisor the number to divide by
     * @return the quotient of dividend divided by divisor
     * @throws IllegalArgumentException if divisor is zero
     */
    public double divide(int dividend, int divisor) {
        if (divisor == 0) {
            logger.error("Division by zero attempted with dividend: {}", dividend);
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        logger.debug("Dividing {} / {}", dividend, divisor);
        return (double) dividend / divisor;
    }

    /**
     * Calculates the modulo (remainder) of the first integer divided by the second.
     *
     * @param dividend the number to be divided
     * @param divisor the number to divide by
     * @return the remainder of dividend divided by divisor
     * @throws IllegalArgumentException if divisor is zero
     */
    public int modulo(int dividend, int divisor) {
        if (divisor == 0) {
            logger.error("Modulo by zero attempted with dividend: {}", dividend);
            throw new IllegalArgumentException("Cannot calculate modulo with zero divisor");
        }
        logger.debug("Calculating {} % {}", dividend, divisor);
        return dividend % divisor;
    }

    /**
     * Calculates the power of a base raised to an exponent.
     *
     * @param base the base number
     * @param exponent the exponent to raise the base to
     * @return the result of base raised to the power of exponent
     */
    public double power(int base, int exponent) {
        logger.debug("Calculating {} ^ {}", base, exponent);
        return Math.pow(base, exponent);
    }

    /**
     * Calculates the percentage value by multiplying the input by 100.
     *
     * @param value the decimal value to convert to percentage
     * @return the percentage representation of the value
     */
    public int calculatePercentage(int value) {
        logger.debug("Calculating percentage for value: {}", value);
        return value * PERCENTAGE_MULTIPLIER;
    }

    /**
     * Calculates the square root of a non-negative number.
     *
     * @param number the number to calculate the square root of
     * @return the square root of the number
     * @throws IllegalArgumentException if number is negative
     */
    public double squareRoot(int number) {
        if (number < 0) {
            logger.error("Square root of negative number attempted: {}", number);
            throw new IllegalArgumentException("Cannot calculate square root of negative number: " + number);
        }
        logger.debug("Calculating square root of {}", number);
        return Math.sqrt(number);
    }

    /**
     * Calculates the absolute value of a number.
     *
     * @param number the number to get the absolute value of
     * @return the absolute value of the number
     */
    public int absoluteValue(int number) {
        logger.debug("Calculating absolute value of {}", number);
        return Math.abs(number);
    }

    /**
     * Parses a string input to an integer value.
     * Returns the default value if parsing fails or input is invalid.
     *
     * @param input the string to parse
     * @return the parsed integer value, or DEFAULT_PARSE_VALUE if parsing fails
     */
    public int parseInteger(String input) {
        if (input == null || input.trim().isEmpty()) {
            logger.warn("Input string is null or empty, returning default value");
            return DEFAULT_PARSE_VALUE;
        }
        try {
            int result = Integer.parseInt(input.trim());
            logger.debug("Successfully parsed '{}' to {}", input, result);
            return result;
        } catch (NumberFormatException e) {
            logger.error("Failed to parse input '{}' to integer", input, e);
            return DEFAULT_PARSE_VALUE;
        }
    }

    /**
     * Logs the result of a calculation.
     *
     * @param result the result to log
     */
    public void logResult(int result) {
        logger.info("Calculation result: {}", result);
    }
}
