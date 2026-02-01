#!/bin/bash

# Script to test the Copilot Code Review workflow
# This creates a test branch with intentional code issues

set -e

echo "🤖 Copilot Code Review - Test Setup Script"
echo "==========================================="
echo ""

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Function to print colored output
print_status() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

print_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Check if we're in the right directory
if [ ! -f "pom.xml" ]; then
    print_error "pom.xml not found. Please run this script from the project root."
    exit 1
fi

# Check if git is initialized
if [ ! -d ".git" ]; then
    print_warning "Git repository not initialized. Initializing..."
    git init
    print_success "Git repository initialized"
fi

# Check for uncommitted changes in Calculator.java
if git diff --quiet src/main/java/com/example/Calculator.java 2>/dev/null; then
    print_status "No uncommitted changes in Calculator.java"
else
    print_warning "You have uncommitted changes in Calculator.java"
    echo "Do you want to commit them first? (y/n)"
    read -r response
    if [ "$response" = "y" ]; then
        git add src/main/java/com/example/Calculator.java
        git commit -m "Clean version of Calculator.java"
        print_success "Changes committed"
    fi
fi

echo ""
echo "Choose a test scenario:"
echo "1) Create PR with the clean code (should pass all checks)"
echo "2) Create PR with intentional issues (should trigger review comments)"
echo "3) Both - Create two PRs to compare"
echo ""
read -p "Enter your choice (1-3): " choice

case $choice in
    1)
        print_status "Creating branch with clean code..."
        git checkout -b test/clean-code-$(date +%s) 2>/dev/null || git checkout test/clean-code-$(date +%s)

        # Ensure the clean Calculator.java is committed
        git add src/main/java/com/example/Calculator.java
        git add src/test/java/com/example/CalculatorTest.java
        git add pom.xml
        git commit -m "feat: Clean Calculator implementation following all guidelines

        - Added proper Javadoc to all public methods
        - Replaced magic numbers with named constants
        - Using SLF4J logging instead of System.out.println
        - Proper exception handling with specific exceptions
        - Comprehensive unit tests with 80%+ coverage
        - Input validation for all methods" || true

        print_success "Clean code branch created"
        print_status "Push this branch and create a PR to see clean code review"
        echo ""
        echo "Next steps:"
        echo "  git push -u origin $(git branch --show-current)"
        echo "  Then create a PR on GitHub"
        ;;

    2)
        print_status "Creating branch with intentional issues..."
        BRANCH_NAME="test/with-issues-$(date +%s)"
        git checkout -b $BRANCH_NAME 2>/dev/null || git checkout $BRANCH_NAME

        # Copy the issues file to replace Calculator.java temporarily
        print_status "Introducing intentional issues to Calculator.java..."

        # Create a version with issues
        cat > src/main/java/com/example/Calculator.java << 'EOF'
package com.example;

/**
 * A simple calculator class with basic arithmetic operations
 * NOTE: This version has intentional issues for testing code review
 */
public class Calculator {

    // Missing Javadoc
    public int add(int a, int b) {
        return a + b;
    }

    // Using System.out.println
    public void printResult(int result) {
        System.out.println("Result: " + result);
    }

    // Catching generic Exception
    public int readValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return 0;
        }
    }

    // No input validation
    public double divide(int a, int b) {
        return (double) a / b;
    }

    // Empty catch block
    public int parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            // Empty catch
        }
        return 0;
    }

    // Magic number
    public int calculatePercentage(int x) {
        return x * 100;
    }

    // TODO comment
    public void futureMethod() {
        // TODO: Implement this later
    }
}
EOF

        git add src/main/java/com/example/Calculator.java
        git commit -m "feat: Add calculator methods (with issues for review testing)

        This commit intentionally includes code quality issues to test
        the automated Copilot review system:
        - Missing Javadoc on some methods
        - Using System.out.println
        - Catching generic Exception
        - No input validation
        - Empty catch blocks
        - Magic numbers
        - TODO comments"

        print_success "Branch with issues created"
        print_status "Push this branch and create a PR to see review comments"
        echo ""
        echo "Next steps:"
        echo "  git push -u origin $(git branch --show-current)"
        echo "  Then create a PR on GitHub"
        ;;

    3)
        print_status "Creating both branches..."

        # Clean version
        git checkout -b test/clean-code-$(date +%s) 2>/dev/null
        git add src/main/java/com/example/Calculator.java src/test/java/com/example/CalculatorTest.java pom.xml
        git commit -m "feat: Clean Calculator implementation" || true
        CLEAN_BRANCH=$(git branch --show-current)

        # Switch back and create issues version
        git checkout main 2>/dev/null || git checkout master
        BRANCH_NAME="test/with-issues-$(date +%s)"
        git checkout -b $BRANCH_NAME

        # Add the issues file
        git add src/main/java/com/example/CalculatorWithIssues.java
        git commit -m "feat: Add calculator with various code quality issues"
        ISSUES_BRANCH=$(git branch --show-current)

        print_success "Both branches created"
        echo ""
        echo "Clean code branch: $CLEAN_BRANCH"
        echo "Issues branch: $ISSUES_BRANCH"
        echo ""
        echo "Next steps:"
        echo "  git push -u origin $CLEAN_BRANCH"
        echo "  git push -u origin $ISSUES_BRANCH"
        echo "  Then create PRs for both branches on GitHub"
        ;;

    *)
        print_error "Invalid choice"
        exit 1
        ;;
esac

echo ""
print_success "✅ Test setup complete!"
echo ""
echo "📋 What happens next:"
echo "1. Push the branch to GitHub"
echo "2. Create a Pull Request"
echo "3. GitHub Actions will automatically trigger"
echo "4. The Copilot review workflow will analyze the code"
echo "5. You'll see automated comments on the PR"
echo ""
print_status "View the workflow status at: GitHub > Actions tab"
