# Quick Reference: Copilot Code Review

## 🚀 Quick Commands

### Run Tests
```bash
mvn test
```

### Build Project
```bash
mvn clean compile
```

### Test Review System
```bash
./test-copilot-review.sh
```

## 📁 Key Files

| File | Purpose |
|------|---------|
| `Calculator.java` | ✅ Clean, production-ready code |
| `CalculatorWithIssues.java` | 🔴 Example with 15 issues |
| `CalculatorTest.java` | ✅ 23 passing tests |
| `.github/workflows/copilot-code-review.yml` | Official Copilot review |
| `.github/workflows/code-review-custom.yml` | Custom review (no subscription needed) |
| `.github/copilot-instructions.md` | Coding guidelines |
| `COPILOT_REVIEW_SETUP.md` | Full documentation |

## 🎯 Common Tasks

### Create a Test PR with Issues
```bash
./test-copilot-review.sh
# Choose option 2
git push origin <branch-name>
# Create PR on GitHub
```

### Create a Test PR with Clean Code
```bash
./test-copilot-review.sh
# Choose option 1
git push origin <branch-name>
# Create PR on GitHub
```

### View Test Results
```bash
mvn test
# or
mvn surefire-report:report
```

## ✅ What's Fixed in Clean Code

- [x] Proper Javadoc on all public methods
- [x] Named constants (no magic numbers)
- [x] SLF4J logging (no System.out.println)
- [x] Specific exception handling
- [x] Input validation everywhere
- [x] No empty catch blocks
- [x] Comprehensive test coverage (23 tests)

## 🔴 Issues in CalculatorWithIssues.java

1. Missing Javadoc
2. Magic numbers
3. System.out.println usage
4. Generic Exception catching
5. Empty catch blocks
6. No input validation
7. Public fields
8. String concatenation in loops
9. Commented-out code
10. TODO comments
11. Hardcoded credentials
12. Resource leaks
13. God methods
14. Missing @param/@return tags
15. No null checks

## 📊 Test Coverage

| Method | Tests | Status |
|--------|-------|--------|
| add() | 3 | ✅ |
| subtract() | 2 | ✅ |
| multiply() | 2 | ✅ |
| divide() | 2 | ✅ |
| modulo() | 2 | ✅ |
| power() | 4 | ✅ |
| calculatePercentage() | 1 | ✅ |
| readValue() | 2 | ✅ |
| parseNumbers() | 2 | ✅ |
| sqrt() | 2 | ✅ |
| printResult() | 1 | ✅ |
| **TOTAL** | **23** | **✅** |

## 🎓 Review Checklist

When creating a PR, the review checks:

### Must Have ✅
- [ ] Javadoc on all public methods
- [ ] @param and @return tags
- [ ] Input validation
- [ ] Specific exception types
- [ ] Proper logging (no System.out)
- [ ] Unit tests for new methods
- [ ] No hardcoded credentials

### Should Have 🟡
- [ ] Named constants
- [ ] @DisplayName on tests
- [ ] Descriptive variable names
- [ ] No TODO comments
- [ ] No commented-out code

### Nice to Have 🔵
- [ ] Parameterized tests
- [ ] Stream API usage
- [ ] Optional returns
- [ ] Builder patterns

## 🐛 Troubleshooting

### Build fails?
```bash
mvn clean install
```

### Tests fail?
```bash
mvn test -X  # Debug mode
```

### Workflow not running?
1. Check Actions are enabled
2. Verify workflow file syntax
3. Check PR includes .java files

### No review comments?
1. Wait 1-2 minutes
2. Check Actions tab
3. Verify permissions in workflow

## 🔗 Links

- [Full Setup Guide](COPILOT_REVIEW_SETUP.md)
- [Coding Guidelines](.github/copilot-instructions.md)
- [GitHub Actions](https://github.com/features/actions)
- [GitHub Copilot](https://github.com/features/copilot)

---

**Need help?** Check `COPILOT_REVIEW_SETUP.md` for detailed instructions.
