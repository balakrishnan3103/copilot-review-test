package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class with intentional issues
 */
public class CalculatorWithIssuesTest {

    @Test
    public void testAddNumbers() {
        CalculatorWithIssues calc = new CalculatorWithIssues();
        System.out.println("Testing add");  // Issue: System.out.println in test
        assertEquals(5, calc.addNumbers(2, 3));
    }

    @Test
    public void testDivide() {
        CalculatorWithIssues calc = new CalculatorWithIssues();
        // TODO: Add more test cases  // Issue: TODO comment
        assertEquals(5, calc.divide(10, 2));
    }

    @Test
    public void testParseData() {
        CalculatorWithIssues calc = new CalculatorWithIssues();
        try {
            String result = calc.parseData("hello");
            assertEquals("HELLO", result);
        } catch (Exception e) {  // Issue: Generic Exception
            System.err.println("Test failed");  // Issue: System.err.println
        }
    }
}
