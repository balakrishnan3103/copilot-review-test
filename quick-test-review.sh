#!/bin/bash
# Quick test script for code review
BRANCH="test/demo-review-$(date +%s)"
git checkout -b $BRANCH
git add src/main/java/com/example/ReviewTestDemo.java
git commit -m "test: Add code with issues for review demo"
git push origin $BRANCH
echo "✅ Done! Create PR from $BRANCH to main on GitHub"
