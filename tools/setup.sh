#!/usr/bin/env bash

# Resolve git repository root
REPO_ROOT="$(git rev-parse --show-toplevel 2>/dev/null)"
if [ -z "$REPO_ROOT" ]; then
    echo "❌ Error: Not inside a git repository."
    exit 1
fi

HOOKS_DIR="$REPO_ROOT/.git/hooks"
PRE_COMMIT_HOOK="$HOOKS_DIR/pre-commit"

mkdir -p "$HOOKS_DIR"

echo "🔧 Setting up git pre-commit hook..."

cat << 'EOF' > "$PRE_COMMIT_HOOK"
#!/bin/bash
set -e

echo "⏳ Auto running Spotless to format code..."
./gradlew spotlessApply --daemon

echo "⏳ Staging formatted files..."
git add -u

echo "⏳ Checking lint (devDebug)..."
./gradlew lintDevDebug --daemon

echo "✅ Spotless & Lint passed successfully!"
EOF

chmod +x "$PRE_COMMIT_HOOK"

echo "✅ Pre-commit hook successfully configured at: $PRE_COMMIT_HOOK"
