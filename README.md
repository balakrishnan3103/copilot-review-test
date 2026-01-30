# Sample Java Project

A simple Java project demonstrating basic Maven project structure with a Calculator application and GitHub Copilot integration.

## Project Structure

```
copilot-review-test/
├── .github/
│   └── copilot-instructions.md               # GitHub Copilot guidelines
├── pom.xml                                    # Maven configuration
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               ├── App.java              # Main application class
│   │               └── Calculator.java       # Calculator utility class
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── CalculatorTest.java   # Unit tests for Calculator
└── README.md                                  # Project documentation
```

## Features

- **Calculator Class**: Basic arithmetic operations (add, subtract, multiply, divide)
- **Main Application**: Demonstrates usage of the Calculator class
- **Unit Tests**: JUnit 5 tests for the Calculator class (5 tests, all passing)
- **Maven Build**: Standard Maven project structure
- **GitHub Copilot Integration**: Instructions for intelligent code reviews

## Requirements

- Java 11 or higher
- Maven 3.6 or higher

## Building the Project

To compile the project:

```bash
mvn compile
```

## Running Tests

To run the unit tests:

```bash
mvn test
```

## Running the Application

To run the main application:

```bash
mvn exec:java -Dexec.mainClass="com.example.App"
```

Or build and run the JAR:

```bash
mvn clean package
java -jar target/sample-java-project-1.0-SNAPSHOT.jar
```

## Expected Output

```
Hello, World!
5 + 3 = 8
10 - 4 = 6
6 * 7 = 42
20 / 4 = 5.0
```
## GitHub Copilot Integration

This project includes `.github/copilot-instructions.md` which tells GitHub Copilot how to review your code.

### What's Included

The instructions file contains:
- Code style guidelines (Java conventions, formatting)
- Testing standards (JUnit 5 best practices)
- Documentation requirements (Javadoc standards)
- Error handling patterns
- Common patterns to use and anti-patterns to avoid

### How to Use

1. **Install GitHub Copilot** in your IDE (VS Code, IntelliJ IDEA, etc.)
2. **Open this project** - Copilot automatically reads `.github/copilot-instructions.md`
3. **Start coding** - Get suggestions that follow project guidelines
4. **Create a PR** - Copilot reviews based on the instructions (requires Enterprise/Business)

### Try Copilot Chat

Ask questions like:
- "Review this code against the project guidelines"
- "How should I document this method?"
- "What test cases should I add?"

