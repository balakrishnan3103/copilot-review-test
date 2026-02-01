# Git Commands - Commit and Push Guide

## 🚀 Quick Start Commands

### If Git is NOT initialized yet:

```bash
# Navigate to project directory
cd /Users/balakrishnan.ashokkumar/Documents/Copliot-Test/copilot-review-test

# Initialize git repository
git init

# Add all files
git add .

# Commit with message
git commit -m "Initial commit: Clean code with automated Copilot review setup

- Calculator.java follows all coding standards (Javadoc, logging, validation)
- 23 unit tests with 100% pass rate
- GitHub Actions workflows for automated code review
- Comprehensive documentation and test tools included"

# Set main branch
git branch -M main

# Add your GitHub repository (replace with your actual repo URL)
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git

# Push to GitHub
git push -u origin main
```

### If Git is ALREADY initialized:

```bash
# Navigate to project directory
cd /Users/balakrishnan.ashokkumar/Documents/Copliot-Test/copilot-review-test

# Check status
git status

# Add all files
git add .

# Commit
git commit -m "Setup automated Copilot code review with clean code"

# Push to main branch
git push origin main
```

---

## 📋 Step-by-Step Guide

### Step 1: Check Current Git Status

```bash
cd /Users/balakrishnan.ashokkumar/Documents/Copliot-Test/copilot-review-test
git status
```

**If you see:** "fatal: not a git repository" → Go to Step 2
**If you see:** file listings → Go to Step 3

### Step 2: Initialize Git (First Time Only)

```bash
# Initialize git
git init

# Check if it worked
git status
```

### Step 3: Add Files

```bash
# Add all files
git add .

# Or add specific files
git add src/
git add .github/
git add pom.xml
git add *.md
git add *.sh

# Verify what's staged
git status
```

### Step 4: Commit Changes

```bash
# Commit with detailed message
git commit -m "Initial commit: Automated Copilot review setup

Features:
- Clean Calculator.java (A+ quality, all standards met)
- 23 passing unit tests with comprehensive coverage
- GitHub Actions workflows for automated PR reviews
- Complete documentation (setup guides, references)
- Test tools and example files

Quality Metrics:
- 100% Javadoc coverage
- 100% test pass rate
- SLF4J logging framework
- Input validation on all methods
- Specific exception handling"
```

### Step 5: Set Branch to Main

```bash
# Rename branch to main (if needed)
git branch -M main
```

### Step 6: Add Remote Repository

**First, create a repository on GitHub**, then:

```bash
# Add remote (replace with your actual URL)
git remote add origin https://github.com/YOUR_USERNAME/copilot-review-test.git

# Verify remote was added
git remote -v
```

### Step 7: Push to GitHub

```bash
# Push to main branch (first time)
git push -u origin main

# For subsequent pushes
git push
```

---

## 🔧 Alternative: If Remote Already Exists

```bash
# Check existing remotes
git remote -v

# If origin already exists but wrong URL, update it:
git remote set-url origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git

# Then push
git push -u origin main
```

---

## 🧪 Create Test Branch (To Test Copilot Review)

After pushing main, create a test branch with issues:

```bash
# Use the test script
./test-copilot-review.sh
# Choose option 2 (with issues)

# Or manually:
git checkout -b test/copilot-review-demo

# Add the file with issues
git add src/main/java/com/example/CalculatorWithIssues.java
git commit -m "Add calculator with intentional issues for review testing"

# Push test branch
git push -u origin test/copilot-review-demo
```

Then go to GitHub and create a Pull Request from `test/copilot-review-demo` to `main`.

---

## 🔄 Rename Branch

If you need to rename a branch (e.g., `test/add-new-method-commented` → `test/demo-code-review`):

```bash
# Method 1: Rename current branch (you're on the branch)
git branch -m test/demo-code-review
git push origin --delete test/add-new-method-commented
git push origin test/demo-code-review
git push origin -u test/demo-code-review

# Method 2: Rename another branch (not currently on it)
git branch -m old-branch-name new-branch-name
git push origin --delete old-branch-name
git push origin new-branch-name
git push origin -u new-branch-name
```

**See [GIT_BRANCH_RENAME.md](GIT_BRANCH_RENAME.md) for detailed guide**

---

## 📊 Common Git Commands Reference

```bash
# Check status
git status

# View commit history
git log --oneline

# View remotes
git remote -v

# View branches
git branch -a

# Switch branches
git checkout main
git checkout -b feature/new-branch

# Pull latest changes
git pull origin main

# View differences
git diff

# Unstage files
git reset HEAD <file>

# Discard changes
git checkout -- <file>
```

---

## ⚠️ Troubleshooting

### Problem: "fatal: not a git repository"
**Solution:** Run `git init` first

### Problem: "fatal: remote origin already exists"
**Solution:** 
```bash
git remote remove origin
git remote add origin <your-repo-url>
```

### Problem: "rejected - non-fast-forward"
**Solution:**
```bash
# If you're sure you want to overwrite remote
git push -f origin main

# Or pull first and merge
git pull origin main --allow-unrelated-histories
git push origin main
```

### Problem: "Permission denied (publickey)"
**Solution:** Set up SSH keys or use HTTPS with token
```bash
# Use HTTPS with personal access token
git remote set-url origin https://github.com/USERNAME/REPO.git

# Or set up SSH key
ssh-keygen -t ed25519 -C "your_email@example.com"
# Add to GitHub: Settings > SSH and GPG keys
```

### Problem: "Author identity unknown"
**Solution:**
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

---

## 🎯 Complete Workflow Example

Here's the complete sequence from start to finish:

```bash
# 1. Navigate to project
cd /Users/balakrishnan.ashokkumar/Documents/Copliot-Test/copilot-review-test

# 2. Initialize git (if needed)
git init

# 3. Configure git (if first time)
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# 4. Add all files
git add .

# 5. Commit
git commit -m "Initial commit: Automated Copilot review setup"

# 6. Set main branch
git branch -M main

# 7. Add remote (create repo on GitHub first!)
git remote add origin https://github.com/YOUR_USERNAME/copilot-review-test.git

# 8. Push
git push -u origin main

# 9. Test the review system
./test-copilot-review.sh
# Choose option 2

# 10. Push test branch
git push origin test/with-issues-XXXXX

# 11. Go to GitHub and create Pull Request
```

---

## 📝 What Happens After Push?

1. ✅ Code is uploaded to GitHub
2. ✅ Repository is now visible online
3. ✅ Workflows are registered (but won't run until PR is created)
4. ✅ Documentation is rendered on GitHub

**To see automated review in action:**
- Create a Pull Request (from test branch to main)
- Workflows will trigger automatically
- Check the "Actions" tab to see workflows running
- Review comments will appear on the PR

---

## 🚀 Ready to Push!

Run these commands now:

```bash
cd /Users/balakrishnan.ashokkumar/Documents/Copliot-Test/copilot-review-test
git init
git add .
git commit -m "Initial commit: Automated Copilot review with clean code"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
git push -u origin main
```

**Don't forget to:**
1. Create the repository on GitHub first
2. Replace `YOUR_USERNAME` and `YOUR_REPO` with actual values
3. Run `./test-copilot-review.sh` after pushing to test the review system

Good luck! 🎉
