# rinha-backend-2023-q3-java

Rinha backend 2023 q3

## Build

```bash
> gradle build
```

## Graalvm Native Compilation

```bash
> gradle nativeCompile
```

Output: ./build/generated/

## GraalVM CE Installation

GraalVM CE 21 Download: [link](https://github.com/graalvm/graalvm-ce-dev-builds/releases/tag/24.0.0-dev-20230907_0337)

```bash
mv ~/Downloads/graalvm-community-openjdk-21+35.1 ~/bin
sdk install java graalvm-ce-21 $HOME/bin/graalvm-community-openjdk-21+35.1/Contents/Home
```

Mac:
```bash
sudo xattr -r -d com.apple.quarantine ~/bin/graalvm-espresso-community-openjdk-21+35.1
```

```bash
> sdk default java graalvm-ce-21
```
