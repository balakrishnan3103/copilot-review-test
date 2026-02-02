package com.example;

/**
 * Demo class to test automated code review
 */
public class ReviewTestDemo {

    // ISSUE: Missing Javadoc for public method
    public int addNumbers(int a, int b) {
        System.out.println("Adding numbers: " + a + " + " + b);  // ISSUE: System.out.println
        return a + b;
    }

    // ISSUE: Catching generic Exception
    public String readFile(String path) {
        try {
            // some file reading code
            return "content";
        } catch (Exception e) {  // ISSUE: Too generic
            return null;  // ISSUE: Returning null
        }
    }

    // ISSUE: Empty catch block
    public void processData() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // ISSUE: Empty catch block
        }
    }

    // ISSUE: Magic numbers
    public int calculateDiscount(int price) {
        return price * 85 / 100;  // ISSUE: Magic numbers 85 and 100
    }

    // TODO: Implement this method later  // ISSUE: TODO comment
    public void futureMethod() {
        System.out.println("Not implemented");  // ISSUE: System.out.println
    }

    // ISSUE: No input validation
    public double divide(int a, int b) {
        return (double) a / b;  // ISSUE: No check for b == 0
    }

    // Multiple issues in one method
    public int complexMethod(String input) {
        try {
            int value = Integer.parseInt(input);
            System.out.println("Parsed: " + value);  // ISSUE: System.out.println
            if (value > 50) {  // ISSUE: Magic number
                return value * 2;
            }
            return value;
        } catch (Exception e) {  // ISSUE: Generic Exception
            return 0;
        }
    }
}
