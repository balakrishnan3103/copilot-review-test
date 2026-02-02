package com.example;

import java.util.List;
import java.util.ArrayList;

/**
 * DataProcessor class for processing data
 * Contains intentional issues for automated code review testing
 */
public class DataProcessor {

    // ISSUE: Missing Javadoc
    public void processRecords(List<String> records) {
        System.out.println("Processing " + records.size() + " records");  // ISSUE: System.out

        for (String record : records) {
            // ISSUE: Null pointer - no null check
            String processed = record.toUpperCase();  // NPE if record is null
            System.out.println(processed);  // ISSUE: System.out
        }
    }

    // ISSUE: Generic Exception, no Javadoc
    public int convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {  // ISSUE: Too generic
            return -1;  // ISSUE: Magic number
        }
    }

    // ISSUE: Multiple null pointer issues
    public String getFirstElement(List<String> items) {
        return items.get(0);  // ISSUE: NPE if items is null, IndexOutOfBounds if empty
    }

    // ISSUE: Empty catch, no validation
    public double calculateAverage(int[] numbers) {
        try {
            int sum = 0;
            for (int num : numbers) {  // ISSUE: NPE if numbers is null
                sum += num;
            }
            return sum / numbers.length;  // ISSUE: Division by zero if length is 0
        } catch (ArithmeticException e) {
            // ISSUE: Empty catch block
        }
        return 0.0;
    }

    // ISSUE: No input validation, magic numbers
    public String formatPhoneNumber(String phone) {
        if (phone.length() == 10) {  // ISSUE: NPE if phone is null, magic number 10
            return phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6);  // Magic numbers
        }
        return null;  // ISSUE: Return null
    }

    // ISSUE: Null pointer chain
    public int getUserAge(User user) {
        return user.getProfile().getAge();  // ISSUE: Multiple NPE points
    }

    // ISSUE: No Javadoc, using printStackTrace
    public void saveData(String filename, String data) {
        try {
            // Simulate file writing
            if (filename == null || data == null) {  // Good: null check
                throw new IllegalArgumentException();
            }
            System.out.println("Saving to " + filename);  // ISSUE: System.out
        } catch (Exception e) {  // ISSUE: Generic Exception
            e.printStackTrace();  // ISSUE: Using printStackTrace instead of logging
        }
    }

    // ISSUE: Hardcoded values, TODO
    public boolean isValidPassword(String password) {
        // TODO: Add more password complexity checks  // ISSUE: TODO
        if (password == null) return false;

        String adminPassword = "Admin@123";  // ISSUE: Hardcoded credential

        if (password.length() < 8) {  // ISSUE: Magic number
            return false;
        }

        return password.length() <= 20;  // ISSUE: Magic number
    }

    // ISSUE: String concatenation in loop
    public String buildReport(List<String> items) {
        String report = "Report:\n";  // OK start

        for (int i = 0; i < items.size(); i++) {  // ISSUE: NPE if items is null
            report = report + i + ": " + items.get(i) + "\n";  // ISSUE: String concat in loop
        }

        return report;
    }

    // ISSUE: Multiple problems in one method
    public String processInput(String input) {
        try {
            System.out.println("Processing: " + input);  // ISSUE: System.out

            if (input.length() > 100) {  // ISSUE: NPE if input is null, magic number
                input = input.substring(0, 100);  // ISSUE: Magic number
            }

            String[] parts = input.split(",");  // OK after null check above failed

            if (parts.length > 5) {  // ISSUE: Magic number
                return parts[0] + parts[1];
            }

            return null;  // ISSUE: Return null
        } catch (Exception e) {  // ISSUE: Generic Exception
            System.out.println("Error: " + e.getMessage());  // ISSUE: System.out
            return "";
        }
    }

    // ISSUE: No null checks at all
    public void updateUser(User user, String name, String email) {
        user.setName(name);  // ISSUE: NPE if user is null
        user.setEmail(email);  // ISSUE: NPE if user is null
        user.save();  // ISSUE: NPE if user is null
    }

    // ISSUE: Array access without bounds check
    public String getElement(String[] array, int index) {
        return array[index];  // ISSUE: NPE if array null, ArrayIndexOutOfBounds
    }

    // ISSUE: Comparing with == instead of .equals()
    public boolean isEqual(String a, String b) {
        return a == b;  // ISSUE: Should use .equals() for String comparison, NPE if either is null
    }

    // Helper classes
    static class User {
        private String name;
        private String email;
        private Profile profile;

        public Profile getProfile() { return profile; }
        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }
        public void save() { }
    }

    static class Profile {
        private int age;
        public int getAge() { return age; }
    }
}
