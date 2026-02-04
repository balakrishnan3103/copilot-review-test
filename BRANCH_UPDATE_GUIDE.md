# How to Update Both Test Branches with Clean Code

## Current Situation
- You have clean code on your current branch (likely `main` or `master`)
- `test/add-new-method` branch has old code
- `test/calculator-upgraded` branch has old code
- You want both branches updated with the clean code

## Solution Options

### Option 1: Use the Automated Script (Recommended)

```bash
cd /Users/balakrishnan.ashokkumar/Documents/Copliot-Test/copilot-review-test
./update-branches.sh
```

This script will:
1. Commit the clean code on your current branch
2. Update `test/add-new-method` to match current branch
3. Update `test/calculator-upgraded` to match current branch
4. Return you to your original branch

After running the script:
```bash
# Push all branches to remote
git push origin test/add-new-method test/calculator-upgraded

# Or force push if branches exist on remote
git push -f origin test/add-new-method test/calculator-upgraded
```

---

### Option 2: Manual Step-by-Step

#### Step 1: Check current status
```bash
cd /Users/balakrishnan.ashokkumar/Documents/Copliot-Test/copilot-review-test
git branch
git status
```

#### Step 2: Commit clean code (if not already committed)
```bash
git add .
git commit -m "Clean Calculator implementation with Copilot review"
```

#### Step 3: Update test/add-new-method
```bash
# Save current branch name
CURRENT=$(git branch --show-current)

# Switch to or create test/add-new-method
git checkout test/add-new-method || git checkout -b test/add-new-method

# Update it with clean code
git reset --hard $CURRENT

# Verify
git log --oneline -3
ls src/main/java/com/example/
```

#### Step 4: Update test/calculator-upgraded
```bash
# Switch to or create test/calculator-upgraded
git checkout test/calculator-upgraded || git checkout -b test/calculator-upgraded

# Update it with clean code
git reset --hard $CURRENT

# Verify
git log --oneline -3
ls src/main/java/com/example/
```

#### Step 5: Return to original branch
```bash
git checkout $CURRENT
```

#### Step 6: Push branches to remote
```bash
# If branches are new
git push -u origin test/add-new-method
git push -u origin test/calculator-upgraded

# If branches exist on remote (force update)
git push -f origin test/add-new-method
git push -f origin test/calculator-upgraded
```

---

## Verify Everything is Updated

```bash
# View all branches
git log --oneline --all --graph --decorate -10

# Check specific files on each branch
git show test/add-new-method:src/main/java/com/example/Calculator.java | head -20
git show test/calculator-upgraded:src/main/java/com/example/Calculator.java | head -20
```

---

## Next Steps: Create Pull Request for Testing

After updating both branches:

1. **Go to GitHub** and create a Pull Request
   - **From:** `test/calculator-upgraded`
   - **To:** `test/add-new-method`

2. **The GitHub Action will trigger** and review the clean code

3. **Expected Result:** No issues should be found since the code is clean

4. **Later for Phase 2:** Add intentional issues to `test/calculator-upgraded` to verify the review catches them

---

## Troubleshooting

### If you get "fatal: A branch named 'test/add-new-method' already exists"
The branch exists but may be out of date. Use:
```bash
git checkout test/add-new-method
git reset --hard main  # or your current branch name
```

### If you can't push because of conflicts
Use force push (since you want to replace the old code):
```bash
git push -f origin test/add-new-method
git push -f origin test/calculator-upgraded
```

### If you need to see what's on a remote branch
```bash
git fetch origin
git log origin/test/add-new-method --oneline -5
git log origin/test/calculator-upgraded --oneline -5
```

---

## Quick Reference

```bash
# See all branches (local and remote)
git branch -a

# See what files are different between branches
git diff test/add-new-method..test/calculator-upgraded

# Delete a branch locally (if you need to start fresh)
git branch -D test/add-new-method

# Delete a branch remotely (if you need to start fresh)
git push origin --delete test/add-new-method
```
