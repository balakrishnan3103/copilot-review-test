# Quick Steps to Update Branches - Run These Commands

## Step 1: Check your current situation
```bash
cd /Users/balakrishnan.ashokkumar/Documents/Copliot-Test/copilot-review-test
git branch --show-current
git status
```

## Step 2: Commit clean code on current branch
```bash
git add .
git commit -m "Clean Calculator implementation with comprehensive tests"
```

## Step 3: Update test/add-new-method branch
```bash
# Save current branch
CURRENT=$(git branch --show-current)

# Create or checkout test/add-new-method
git checkout test/add-new-method 2>/dev/null || git checkout -b test/add-new-method

# Update with clean code
git reset --hard $CURRENT

# Verify
echo "✓ test/add-new-method updated"
ls src/main/java/com/example/
```

## Step 4: Update test/calculator-upgraded branch
```bash
# Create or checkout test/calculator-upgraded
git checkout test/calculator-upgraded 2>/dev/null || git checkout -b test/calculator-upgraded

# Update with clean code
git reset --hard $CURRENT

# Verify
echo "✓ test/calculator-upgraded updated"
ls src/main/java/com/example/
```

## Step 5: Return to original branch
```bash
git checkout $CURRENT
```

## Step 6: View all branches to verify
```bash
git log --oneline --all --graph --decorate -10
```

## Step 7: Push to GitHub
```bash
# Force push both branches (since we're replacing old code)
git push -f origin test/add-new-method
git push -f origin test/calculator-upgraded

# Also push current branch if needed
git push origin $CURRENT
```

## Step 8: Verify on GitHub
- Check that both branches have the clean Calculator code
- Calculator.java should have ~178 lines with proper Javadoc
- CalculatorTest.java should have 82 tests

## Step 9: Create Pull Request
1. Go to your GitHub repository
2. Click "Pull requests" → "New pull request"
3. Set:
   - **Base:** `test/add-new-method`
   - **Compare:** `test/calculator-upgraded`
4. Create the PR
5. GitHub Actions will trigger and review the code
6. **Expected:** No issues found (clean code)

---

## All Commands in One Block (Copy & Paste)

```bash
cd /Users/balakrishnan.ashokkumar/Documents/Copliot-Test/copilot-review-test

# Commit clean code
git add .
git commit -m "Clean Calculator implementation with comprehensive tests"

# Save current branch
CURRENT=$(git branch --show-current)

# Update test/add-new-method
git checkout test/add-new-method 2>/dev/null || git checkout -b test/add-new-method
git reset --hard $CURRENT
echo "✓ test/add-new-method updated"

# Update test/calculator-upgraded
git checkout test/calculator-upgraded 2>/dev/null || git checkout -b test/calculator-upgraded
git reset --hard $CURRENT
echo "✓ test/calculator-upgraded updated"

# Return to original branch
git checkout $CURRENT

# View branches
git log --oneline --all --graph --decorate -10

# Push to GitHub
git push -f origin test/add-new-method test/calculator-upgraded
```

---

## Troubleshooting

### If you get "Already up to date" or nothing to commit
That's okay! It means the clean code is already committed.

### If you get conflicts
Use `-f` (force) flag to override:
```bash
git push -f origin test/add-new-method test/calculator-upgraded
```

### To verify branches are identical
```bash
git diff test/add-new-method..test/calculator-upgraded
```
(Should show no differences if both updated correctly)
