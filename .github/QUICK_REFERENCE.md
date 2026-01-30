# Quick Reference: GitHub Copilot Instructions

This is a quick reference for the guidelines in `.github/copilot-instructions.md`.

## ✅ Code Style Checklist

- [ ] Use camelCase for methods and variables
- [ ] Use PascalCase for class names
- [ ] Keep lines under 120 characters
- [ ] Use 4 spaces for indentation (no tabs)
- [ ] Always use braces for control structures

## ✅ Documentation Checklist

- [ ] Class-level Javadoc explaining purpose
- [ ] Method Javadoc with description
- [ ] `@param` for all parameters
- [ ] `@return` for non-void methods
- [ ] `@throws` for declared exceptions

## ✅ Testing Checklist

- [ ] Unit tests for all public methods
- [ ] Test method name: `test[MethodName][Scenario]`
- [ ] `@DisplayName` with readable description
- [ ] Test happy path
- [ ] Test boundary conditions
- [ ] Test error conditions
- [ ] 80%+ code coverage

## ✅ Error Handling Checklist

- [ ] Validate inputs at method start
- [ ] Use specific exception types
- [ ] Throw `IllegalArgumentException` for invalid args
- [ ] Include descriptive error messages
- [ ] Log before re-throwing exceptions

## 🚫 Anti-Patterns to Avoid

- ❌ Catching generic `Exception`
- ❌ Empty catch blocks
- ❌ Using `System.out.println()` (use logging)
- ❌ Magic numbers without constants
- ❌ Public fields (use private + getters/setters)
- ❌ God classes
- ❌ Commented-out code in commits

## 💡 Common Patterns to Use

- ✅ StringBuilder for loop concatenation
- ✅ Optional instead of null returns
- ✅ Stream API for collections
- ✅ Builder pattern for complex objects
- ✅ Dependency injection

## 📝 Example: Well-Documented Method

```java
/**
 * Calculates the factorial of a number
 * 
 * @param n the number to calculate factorial for (must be non-negative)
 * @return the factorial of n
 * @throws IllegalArgumentException if n is negative
 */
public long factorial(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("Factorial not defined for negative numbers");
    }
    if (n == 0 || n == 1) {
        return 1;
    }
    long result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

## 📝 Example: Well-Written Test

```java
@Test
@DisplayName("Test factorial with positive numbers")
void testFactorialPositive() {
    assertEquals(1, calculator.factorial(0));
    assertEquals(1, calculator.factorial(1));
    assertEquals(2, calculator.factorial(2));
    assertEquals(6, calculator.factorial(3));
    assertEquals(120, calculator.factorial(5));
}

@Test
@DisplayName("Test factorial throws exception for negative numbers")
void testFactorialNegative() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> calculator.factorial(-1)
    );
    assertTrue(exception.getMessage().contains("negative"));
}
```

## 🔍 Review Focus Areas

1. **Null Safety** - Check for NPE risks
2. **Input Validation** - Validate before use
3. **Test Coverage** - Tests for new code
4. **Exception Handling** - Proper try-catch
5. **Code Duplication** - DRY principle
6. **Performance** - Efficient algorithms
7. **Security** - No vulnerabilities
8. **Resource Management** - Close resources

## 📚 Quick Commands

```bash
# Compile project
mvn compile

# Run tests
mvn test

# Run with coverage
mvn clean verify

# Run application
mvn exec:java -Dexec.mainClass="com.example.App"

# Build JAR
mvn clean package
```

---

**Keep this guide handy while coding!** 📌
