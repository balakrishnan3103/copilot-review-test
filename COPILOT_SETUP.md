# How to Use GitHub Copilot Instructions for Pull Request Reviews

This guide explains how to leverage the `.github/copilot-instructions.md` file for automatic PR reviews.

## What is copilot-instructions.md?

The `copilot-instructions.md` file provides context and guidelines that GitHub Copilot uses when:
- Suggesting code completions in your IDE
- Reviewing pull requests
- Providing inline suggestions
- Answering questions about the codebase

## Setup for PR Reviews

### 1. Enable GitHub Copilot for Pull Requests

To get automatic PR reviews, ensure GitHub Copilot is enabled for your repository:
1. Go to your repository settings
2. Navigate to "Actions" → "General"
3. Enable workflows for pull requests
4. Make sure GitHub Copilot has access to your repository

### 2. Create a Test Pull Request

To see Copilot in action with the instructions:

```bash
# Create a new branch
git checkout -b feature/add-power-function

# Make changes (see example below)
# Edit src/main/java/com/example/Calculator.java

# Commit and push
git add .
git commit -m "Add power function to Calculator"
git push origin feature/add-power-function

# Create a PR on GitHub
```

### 3. Example Code Change

Add this method to `Calculator.java`:

```java
/**
 * Calculates the power of a number
 * @param base the base number
 * @param exponent the exponent
 * @return base raised to the power of exponent
 */
public double power(int base, int exponent) {
    return Math.pow(base, exponent);
}
```

Add corresponding tests to `CalculatorTest.java`:

```java
@Test
@DisplayName("Test power calculation")
void testPower() {
    assertEquals(8.0, calculator.power(2, 3));
    assertEquals(1.0, calculator.power(5, 0));
    assertEquals(0.25, calculator.power(2, -2), 0.0001);
}
```

## What Copilot Will Review

Based on the instructions in `.github/copilot-instructions.md`, Copilot will check:

### ✅ Code Style
- Naming conventions (camelCase, PascalCase)
- Indentation (4 spaces)
- Line length (max 120 characters)
- Brace usage

### ✅ Documentation
- Javadoc comments on public methods
- @param and @return annotations
- Class-level documentation

### ✅ Testing
- Unit tests for new methods
- Test naming conventions
- @DisplayName annotations
- Coverage of edge cases

### ✅ Error Handling
- Input validation
- Proper exception types
- Descriptive error messages

### ✅ Best Practices
- No magic numbers
- DRY principle
- Proper resource management
- Security considerations

## Example PR Review Comments

When you create a PR, GitHub Copilot might provide comments like:

**Good Example:**
```
✅ Great job! This method follows the project guidelines:
- Has proper Javadoc with @param and @return
- Includes comprehensive unit tests
- Uses descriptive naming
- Handles edge cases (exponent = 0)
```

**Suggestions:**
```
💡 Consider adding input validation:
- Check for potential overflow with large exponents
- Add a test case for Integer.MAX_VALUE

📝 Documentation suggestion:
- Add @throws tag if the method can throw any exceptions
- Clarify behavior with negative exponents in Javadoc
```

## Testing Locally with Copilot

In your IDE (VS Code, IntelliJ, etc.):

1. **Enable Copilot**: Install GitHub Copilot extension
2. **Open the project**: Copilot will read `.github/copilot-instructions.md`
3. **Write code**: Copilot suggestions will follow the guidelines
4. **Ask Copilot**: Use Copilot Chat to ask questions about coding standards

### Example Copilot Chat Questions:

- "How should I document this method according to project guidelines?"
- "What test cases should I add for this calculator method?"
- "Does this code follow the project's error handling standards?"
- "Review this method against the project guidelines"

## Continuous Improvement

Update `.github/copilot-instructions.md` as your project evolves:
- Add new patterns you want to enforce
- Document common mistakes to avoid
- Include examples of good and bad code
- Reference specific libraries or frameworks

## Benefits

✅ **Consistent code reviews** across all PRs
✅ **Faster onboarding** for new developers
✅ **Automated best practice enforcement**
✅ **Context-aware suggestions** in your IDE
✅ **Living documentation** that evolves with your project

## Additional Resources

- [GitHub Copilot Documentation](https://docs.github.com/en/copilot)
- [Copilot for Pull Requests](https://docs.github.com/en/copilot/github-copilot-enterprise/copilot-pull-request-summaries)
- [Writing Effective Copilot Instructions](https://github.blog/2023-06-20-how-to-write-better-prompts-for-github-copilot/)

---

**Ready to try it?** Create a branch, make a change, and open a PR to see Copilot in action! 🚀
