#!/usr/bin/env bash
set -euo pipefail

JDK_DIR="/tmp/jdk"
ARCHIVE="/tmp/openjdk.tar.gz"
BASE_URL="https://jdk.java.net/"

rm -rf "$JDK_DIR" "$ARCHIVE"

if ! command -v curl >/dev/null 2>&1; then
    echo "Error: curl is required." >&2
    exit 1
fi

echo "Installing latest GA OpenJDK from jdk.java.net into $JDK_DIR..."

JDK_PAGE="$(
    curl -fsSL "$BASE_URL" \
    | grep -Eo 'Ready for use: <a href="/[0-9]+/">JDK [0-9]+' \
    | sed -E 's#.*href="/([0-9]+)/".*#https://jdk.java.net/\1/#'
)"

if [ -z "$JDK_PAGE" ]; then
    echo "Error: unable to detect latest GA OpenJDK page from $BASE_URL" >&2
    exit 1
fi

echo "Detected JDK page: $JDK_PAGE"

DOWNLOAD_URL="$(
    curl -fsSL "$JDK_PAGE" \
    | grep -Eo 'https://download\.java\.net/java/GA/jdk[0-9][^"]+linux-x64_bin\.tar\.gz' \
    | head -n1
)"

if [ -z "$DOWNLOAD_URL" ]; then
    echo "Error: unable to find Linux x64 OpenJDK archive on $JDK_PAGE" >&2
    exit 1
fi

echo "Downloading: $DOWNLOAD_URL"

rm -rf "$JDK_DIR" "$ARCHIVE"
mkdir -p "$JDK_DIR"

curl -fL "$DOWNLOAD_URL" -o "$ARCHIVE"

tar -xzf "$ARCHIVE" -C "$JDK_DIR" --strip-components=1

export JAVA_HOME="$JDK_DIR"
export PATH="$JAVA_HOME/bin:$PATH"

echo "Using Java from: $(command -v java)"
echo "Using javac from: $(command -v javac)"

java --version
javac --version