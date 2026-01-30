# Sample Java Project

A simple Java project demonstrating basic Maven project structure with a Calculator application.

## Project Structure

```
copilot-review-test/
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
└── README.md
```

## Features

- **Calculator Class**: Basic arithmetic operations (add, subtract, multiply, divide)
- **Main Application**: Demonstrates usage of the Calculator class
- **Unit Tests**: JUnit 5 tests for the Calculator class
- **Maven Build**: Standard Maven project structure

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

This project includes GitHub Copilot instructions to provide intelligent code reviews and suggestions:

### 📋 Copilot Instructions File
`.github/copilot-instructions.md` contains:
- Code style guidelines (Java conventions, formatting)
- Testing standards (JUnit 5 best practices)
- Documentation requirements (Javadoc standards)
- Error handling patterns
- Common anti-patterns to avoid
- Project-specific guidelines

### 🤖 How It Works

When you:
- **Write code**: Copilot suggests code that follows project guidelines
- **Create PRs**: Automated reviews check code against standards
- **Ask questions**: Copilot Chat understands project context

### 🚀 Getting Started with Copilot

1. **Install GitHub Copilot** in your IDE (VS Code, IntelliJ IDEA, etc.)
2. **Open this project** - Copilot will automatically read the instructions
3. **Start coding** - Get context-aware suggestions
4. **Create a PR** - See automated review comments

For detailed setup instructions, see [COPILOT_SETUP.md](COPILOT_SETUP.md)

### ✨ Example Features

Try asking GitHub Copilot Chat:
- "How should I document a new method in Calculator.java?"
- "What test cases should I add for a square root function?"
- "Review my code against the project guidelines"
- "Generate a new arithmetic method following project standards"

### 📝 Pull Request Template

The project includes a PR template (`.github/PULL_REQUEST_TEMPLATE.md`) that:
- Guides contributors through the review checklist
- Ensures all guidelines are considered
- References Copilot instructions for automated reviews

