package com.example;

/**
 * A simple calculator class with basic arithmetic operations
 */
public class Calculator {

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

    // ISSUE 1: Missing Javadoc - violates "All public methods must have Javadoc"
    public int modulo(int a, int b) {
        return a % b;  // ISSUE 2: No input validation for division by zero
    }

    // ISSUE 3: Missing proper Javadoc structure (no @param, @return)
    // Calculates power
    public double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    // ISSUE 4: Magic number without constant
    public int calculate(int x) {
        return x * 100;  // What does 100 represent?
    }

    // ISSUE 5: Using System.out.println instead of logging
    public void printResult(int result) {
        System.out.println("Result: " + result);
    }

    // ISSUE 6: Catching generic Exception
    public int readValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {  // Should catch NumberFormatException specifically
            return 0;
        }
    }

    // ISSUE 7: Empty catch block
    public int parseNumberss(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            // Empty catch - no logging or handling
        }
        return 0;
    }

    /**
     * Calculates square root
     * @param n the number
     * @return square root
     */
    // ISSUE 8: Missing input validation (no check for negative numbers)
    public double sqrt(int n) {
        return Math.sqrt(n);
    }
    //same issue
}
