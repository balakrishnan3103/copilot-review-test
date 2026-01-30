# GitHub Copilot Instructions

This file provides context and guidelines for GitHub Copilot to assist with code reviews and suggestions in this repository.

## Project Overview

This is a sample Java Maven project that demonstrates basic calculator functionality with comprehensive unit testing using JUnit 5.

## Code Style and Standards

### Java Conventions
- Follow standard Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- All public methods must have Javadoc comments with @param and @return annotations
- Maximum line length: 120 characters
- Use 4 spaces for indentation (no tabs)
- Always use braces for if/else/for/while statements, even for single-line blocks

### Testing Standards
- All public methods in service/utility classes must have corresponding unit tests
- Test method names should be descriptive and follow the pattern: `test[MethodName][Scenario]`
- Use `@DisplayName` annotations to provide human-readable test descriptions
- Aim for at least 80% code coverage
- Each test should test one specific behavior
- Use JUnit 5 assertions (assertEquals, assertThrows, etc.)

## Error Handling

- Always validate input parameters at the beginning of public methods
- Throw `IllegalArgumentException` for invalid arguments with descriptive messages
- Use try-catch blocks for operations that may fail (I/O, database, etc.)
- Log errors appropriately before re-throwing or handling

## Documentation Requirements

- All classes must have a class-level Javadoc comment explaining their purpose
- All public methods must have Javadoc with:
  - Brief description of what the method does
  - `@param` tags for all parameters
  - `@return` tag for non-void methods
  - `@throws` tag for declared exceptions
- Complex algorithms should include inline comments explaining the logic

## Code Review Focus Areas

When reviewing pull requests, pay special attention to:

1. **Null Safety**: Check for potential NullPointerExceptions
2. **Input Validation**: Ensure all inputs are validated before use
3. **Test Coverage**: Verify that new code has corresponding tests
4. **Exception Handling**: Check that exceptions are properly caught and handled
5. **Code Duplication**: Identify repeated code that could be refactored
6. **Performance**: Flag potentially inefficient operations (e.g., unnecessary loops)
7. **Security**: Watch for SQL injection, XSS, or other security vulnerabilities
8. **Resource Management**: Ensure proper closing of streams, connections, etc.

## Common Patterns to Suggest

- Use StringBuilder for string concatenation in loops
- Prefer `Optional` over null returns when appropriate
- Use Stream API for collection operations when it improves readability
- Implement builder pattern for classes with many optional parameters
- Use dependency injection instead of tight coupling

## Anti-Patterns to Flag

- Catching generic `Exception` instead of specific exceptions
- Empty catch blocks without logging or comments
- Using `System.out.println()` instead of proper logging framework
- Magic numbers without named constants
- God classes (classes that do too many things)
- Public fields instead of private fields with getters/setters

## Project-Specific Guidelines

### Calculator Class
- All arithmetic operations should handle edge cases (e.g., division by zero)
- Methods should be pure functions (no side effects)
- Return types should be as precise as possible (use double for division)

### Testing Strategy
- Test happy path scenarios
- Test boundary conditions (zero, negative numbers, max values)
- Test error conditions (invalid inputs, exceptions)
- Use parameterized tests for testing multiple similar scenarios

## Pull Request Checklist

Before approving a PR, ensure:
- [ ] Code follows project style guidelines
- [ ] All new public methods have Javadoc comments
- [ ] Unit tests are present and passing
- [ ] No commented-out code is committed
- [ ] No hardcoded credentials or sensitive information
- [ ] Error handling is appropriate
- [ ] Code is DRY (Don't Repeat Yourself)
- [ ] Variable and method names are descriptive
- [ ] Maven build succeeds without warnings

## Helpful Review Comments

When suggesting improvements, be constructive and specific:
- ❌ "This code is bad"
- ✅ "Consider extracting this logic into a separate method for better testability and reusability"

- ❌ "Add tests"
- ✅ "This method should have unit tests covering the cases: valid input, null input, and empty input"

- ❌ "Fix the exception handling"
- ✅ "Instead of catching generic Exception, catch the specific IOException and log the error before re-throwing"

## Additional Resources

- [Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Maven Best Practices](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html)
