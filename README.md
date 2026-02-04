# Calculator Project - GitHub Copilot Code Review Demo

A clean Java Calculator project demonstrating GitHub Copilot automated code reviews on Pull Requests.

## Project Structure

```
copilot-review-test/
├── .github/
│   ├── copilot-instructions.md       # Copilot review guidelines
│   └── workflows/
│       └── code-review-custom.yml    # GitHub Actions workflow
├── pom.xml                           # Maven configuration
├── src/
│   ├── main/java/com/example/
│   │   └── Calculator.java           # Calculator class
│   └── test/java/com/example/
│       └── CalculatorTest.java       # Unit tests (82 tests)
└── README.md
```

## Features

- **Calculator Class**: Complete arithmetic operations
  - Addition, Subtraction, Multiplication, Division
  - Modulo, Power, Square Root, Absolute Value
  - Percentage calculation, Integer parsing
- **Comprehensive Tests**: 82 unit tests with 100% pass rate
- **Clean Code**: Follows all coding standards
- **Proper Logging**: SLF4J instead of System.out.println
- **Input Validation**: Proper exception handling

## Requirements

- Java 11 or higher
- Maven 3.6 or higher

## Building & Testing

```bash
# Compile
mvn compile

# Run tests
mvn test

# Full build
mvn clean package
```

## GitHub Copilot Code Review

### How It Works

1. **Create a PR** with Java code changes
2. **GitHub Actions** triggers automatically
3. **Copilot reviews** based on `.github/copilot-instructions.md`
4. **Review comments** appear on the PR

### Review Guidelines (from copilot-instructions.md)

The automated review checks for:

✅ **Good Practices**
- Proper Javadoc with @param, @return, @throws
- Named constants instead of magic numbers
- SLF4J logging instead of System.out.println
- Specific exception handling
- Input validation

❌ **Anti-Patterns (will be flagged)**
- Generic Exception catching
- Empty catch blocks
- System.out.println usage
- Magic numbers
- Missing documentation

## Testing the Review

### Phase 1: Clean Code (Current State)
The current code follows all guidelines - PR should pass with no issues.

### Phase 2: Add Issues (For Testing)
Create a file `CalculatorWithIssues.java` with intentional issues to verify the review catches them.

## Files Overview

| File | Description |
|------|-------------|
| `Calculator.java` | Clean, well-documented calculator class |
| `CalculatorTest.java` | 82 comprehensive unit tests |
| `copilot-instructions.md` | Review guidelines for Copilot |
| `code-review-custom.yml` | GitHub Actions workflow |

