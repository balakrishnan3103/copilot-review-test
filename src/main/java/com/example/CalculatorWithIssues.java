package com.example;

/**
 * Calculator class with intentional issues for testing Copilot review
 * This file demonstrates various anti-patterns and code quality issues
 * that should be caught by the automated review system
 */
public class CalculatorWithIssues {

    // ISSUE 1: Missing Javadoc for public method
    public int calculate(int x) {
        return x * 100;  // ISSUE 2: Magic number
    }

    // ISSUE 3: Using System.out.println instead of logging
    public void printValue(int val) {
        System.out.println("Value: " + val);
    }

    // ISSUE 4: Catching generic Exception
    public int parseValue(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {  // Too generic!
            return 0;
        }
    }

    // ISSUE 5: No input validation (division by zero)
    public double divide(int a, int b) {
        return (double) a / b;
    }

    // ISSUE 6: Empty catch block
    public void process() {
        try {
            int value = Integer.parseInt("test");
        } catch (NumberFormatException e) {
            // Empty - bad practice!
        }
    }

    // ISSUE 7: Missing @param and @return in Javadoc
    /**
     * Multiplies two numbers
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    // ISSUE 8: God method - does too many things
    public String processData(String input) {
        if (input == null) return null;
        String trimmed = input.trim();
        String upper = trimmed.toUpperCase();
        String replaced = upper.replace(" ", "_");
        String result = replaced + "_PROCESSED";
        System.out.println("Processed: " + result);
        return result;
    }

    // ISSUE 9: Public field instead of private with getter
    public int counter = 0;

    // ISSUE 10: No validation for negative numbers
    public double sqrt(int n) {
        return Math.sqrt(n);
    }

    // ISSUE 11: String concatenation in loop
    public String buildString(String[] items) {
        String result = "";
        for (String item : items) {
            result = result + item + ",";  // Should use StringBuilder
        }
        return result;
    }

    // ISSUE 12: Commented out code
    public int add(int a, int b) {
        // int result = a + b;
        // System.out.println("Result: " + result);
        // return result;
        return a + b;
    }

    // ISSUE 13: TODO comment
    public void futureFeature() {
        // TODO: Implement this feature later
    }

    // ISSUE 14: Hardcoded credentials (security issue)
    private static final String API_KEY = "sk-1234567890abcdef";
    private static final String PASSWORD = "admin123";

    // ISSUE 15: No proper resource management
    public String readFile(String path) {
        try {
            java.io.FileReader fr = new java.io.FileReader(path);
            java.io.BufferedReader br = new java.io.BufferedReader(fr);
            return br.readLine();  // Not closing resources!
        } catch (Exception e) {
            return null;
        }
    }
}
