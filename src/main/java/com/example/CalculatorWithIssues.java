package com.example;

/**
 * Calculator with intentional code issues for testing automated review
 */
public class CalculatorWithIssues {

    // Issue: Public method without Javadoc
    public int addNumbers(int a, int b) {
        System.out.println("Adding: " + a + " + " + b);  // Issue: Using System.out.println
        return a + b;
    }

    public int divide(int x, int y) {
        // Issue: No input validation for division by zero
        return x / y;
    }

    public String parseData(String input) {
        try {
            return input.toUpperCase();
        } catch (Exception e) {  // Issue: Catching generic Exception
            // Issue: Empty catch block
        }
        return null;  // Issue: Returning null
    }

    public int calculate(int num) {
        // Issue: Magic numbers
        if (num > 100) {
            return num * 50;
        }
        return num + 25;
    }

    public void processFile(String filename) {
        // TODO: Implement file processing  // Issue: TODO comment
        System.err.println("Processing: " + filename);  // Issue: System.err.println
    }

    public double computeValue(int input) {
        try {
            double result = input / 10;
            return result;
        } catch (Exception ex) {  // Issue: Generic exception
            System.out.println("Error occurred");  // Issue: System.out.println in catch
            return 0;
        }
    }

    // Issue: No Javadoc
    public boolean isValid(String data) {
        if (data == null) return false;  // This is actually OK
        return data.length() > 0;
    }
}
