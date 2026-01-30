#!/bin/bash

# Script to get Copilot review using CLI
# This allows you to review PRs locally using your instructions

echo "🤖 GitHub Copilot PR Review Helper"
echo "=================================="
echo ""

# Check if gh CLI is installed
if ! command -v gh &> /dev/null; then
    echo "❌ GitHub CLI (gh) is not installed"
    echo "Install it: brew install gh"
    exit 1
fi

# Get PR number
echo "Enter PR number:"
read PR_NUMBER

echo ""
echo "📥 Fetching PR changes..."
gh pr diff $PR_NUMBER > /tmp/pr_changes.diff

echo "🤖 Use Copilot Chat in your IDE and paste:"
echo ""
echo "Review this PR against .github/copilot-instructions.md:"
echo ""
cat /tmp/pr_changes.diff
echo ""
echo "Then copy Copilot's review and post it with:"
echo "gh pr comment $PR_NUMBER --body \"<paste review here>\""
