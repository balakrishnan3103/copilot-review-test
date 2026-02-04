#!/bin/bash

# Script to update both test branches with clean Calculator code

set -e  # Exit on error

echo "=== Updating Git Branches with Clean Code ==="
echo ""

# Get current branch name
CURRENT_BRANCH=$(git branch --show-current)
echo "Current branch: $CURRENT_BRANCH"
echo ""

# Step 1: Commit current clean code
echo "Step 1: Committing clean code on current branch..."
git add .
git commit -m "Clean Calculator implementation with comprehensive tests and Copilot review setup" || echo "Nothing to commit"
echo "✓ Clean code committed"
echo ""

# Step 2: Update test/add-new-method (base branch)
echo "Step 2: Updating test/add-new-method branch..."
git checkout test/add-new-method 2>/dev/null || git checkout -b test/add-new-method
git reset --hard $CURRENT_BRANCH
echo "✓ test/add-new-method updated"
echo ""

# Step 3: Update test/calculator-upgraded branch
echo "Step 3: Updating test/calculator-upgraded branch..."
git checkout test/calculator-upgraded 2>/dev/null || git checkout -b test/calculator-upgraded
git reset --hard $CURRENT_BRANCH
echo "✓ test/calculator-upgraded updated"
echo ""

# Step 4: Return to original branch
echo "Step 4: Returning to $CURRENT_BRANCH..."
git checkout $CURRENT_BRANCH
echo ""

echo "=== Summary ==="
echo "✓ $CURRENT_BRANCH: Clean code committed"
echo "✓ test/add-new-method: Updated to match $CURRENT_BRANCH"
echo "✓ test/calculator-upgraded: Updated to match $CURRENT_BRANCH"
echo ""
echo "Next steps:"
echo "1. Push all branches: git push origin $CURRENT_BRANCH test/add-new-method test/calculator-upgraded"
echo "2. Or force push if needed: git push -f origin test/add-new-method test/calculator-upgraded"
echo "3. Create PR from test/calculator-upgraded to test/add-new-method to test Copilot review"
echo ""
echo "To verify branches:"
echo "  git log --oneline --all --graph --decorate -10"
