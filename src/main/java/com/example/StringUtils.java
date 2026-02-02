package com.example;

/**
 * StringUtils class for string manipulation
 * This file has intentional issues for testing automated review
 */
public class StringUtils {

    // ISSUE: Missing Javadoc
    public String concatenate(String a, String b) {
        System.out.println("Concatenating: " + a + " and " + b);  // ISSUE: System.out.println
        return a + b;
    }

    // ISSUE: Catching generic Exception
    public int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {  // ISSUE: Too generic
            System.out.println("Error parsing: " + value);  // ISSUE: System.out.println
            return 0;
        }
    }

    // ISSUE: Empty catch block
    public String readConfig(String key) {
        try {
            // simulate reading config
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }
            return "value";
        } catch (IllegalArgumentException e) {
            // ISSUE: Empty catch - no logging
        }
        return null;  // ISSUE: Returning null
    }

    // ISSUE: Magic numbers
    public double calculateDiscount(double price, int customerType) {
        if (customerType == 1) {  // ISSUE: Magic number
            return price * 0.9;  // ISSUE: Magic number 0.9 (10% discount)
        } else if (customerType == 2) {  // ISSUE: Magic number
            return price * 0.85;  // ISSUE: Magic number 0.85 (15% discount)
        }
        return price;
    }

    // TODO: Add validation for empty strings  // ISSUE: TODO comment
    public boolean isValid(String input) {
        return input != null && input.length() > 5;  // ISSUE: Magic number 5
    }

    // ISSUE: No input validation (division by zero)
    public double divide(int a, int b) {
        return (double) a / b;  // ISSUE: No check for b == 0
    }

    // Multiple issues in one method
    public String processData(String input) {
        try {
            if (input == null) return null;  // ISSUE: Return null

            System.out.println("Processing: " + input);  // ISSUE: System.out

            String result = input.toUpperCase();

            if (result.length() > 100) {  // ISSUE: Magic number
                result = result.substring(0, 100);  // ISSUE: Magic number
            }

            return result;
        } catch (Exception e) {  // ISSUE: Generic Exception
            e.printStackTrace();  // ISSUE: Using printStackTrace instead of logging
            return "";
        }
    }

    // ISSUE: No Javadoc, hardcoded credentials
    public boolean authenticate(String username) {
        String password = "admin123";  // ISSUE: Hardcoded credential
        System.out.println("Checking credentials");  // ISSUE: System.out
        return username != null;
    }

    // String concatenation in loop
    public String buildList(String[] items) {
        String result = "";  // ISSUE: Should use StringBuilder
        for (String item : items) {
            result = result + item + ",";  // ISSUE: String concatenation in loop
        }
        return result;
    }

    // ISSUE: Null pointer - no null check on input
    public int getLength(String text) {
        return text.length();  // ISSUE: NullPointerException if text is null
    }

    // ISSUE: Null pointer - no null check before method call
    public String toUpperCase(String input) {
        return input.toUpperCase();  // ISSUE: NullPointerException if input is null
    }

    // ISSUE: Multiple null pointer issues
    public String extractFirstWord(String sentence) {
        String[] words = sentence.split(" ");  // ISSUE: NPE if sentence is null
        return words[0].trim();  // ISSUE: NPE if words[0] is null
    }

    // ISSUE: Null pointer in comparison
    public boolean startsWith(String text, String prefix) {
        return text.startsWith(prefix);  // ISSUE: NPE if text or prefix is null
    }

    // ISSUE: Null pointer with array access
    public String getFirstItem(String[] items) {
        return items[0];  // ISSUE: NPE if items is null, ArrayIndexOutOfBounds if empty
    }

    // ISSUE: Chained method calls without null checks
    public int getWordCount(String text) {
        return text.trim().split(" ").length;  // ISSUE: NPE if text is null
    }

    // ISSUE: Null pointer in string operations
    public String concatenateWithSeparator(String a, String b, String separator) {
        return a + separator + b;  // ISSUE: NPE if any parameter is null
    }

    // ISSUE: Dereferencing potentially null object
    public String processUser(User user) {
        return user.getName().toUpperCase();  // ISSUE: NPE if user is null or getName() returns null
    }

    // Helper class for demonstration
    static class User {
        private String name;
        public String getName() { return name; }
    }
}
