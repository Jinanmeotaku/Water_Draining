# Water Drainage Checker

This Java project implements the Weighted Quick Union (union-find) algorithm to determine whether water can percolate from the top row of a soil grid to the bottom row.

## Prerequisites

- Java JDK 8 or higher installed.  
- VS Code with the Java Extension Pack.

## Project Structure

almaliky_jinan_project1/
├── src
│ ├── app.java
│ ├── soil.java
│ └── weightedQuickUnionFind.java
├── README.md
├── sample1.txt
├── sample2.txt
└── sample3.txt

- **src/**: contains `.java` source files  
- **sample*.txt**: example soil grids for testing

## Building (Terminal)

From the project root in your terminal for
running in VS Code, Open the project folder in VS Code:

```bash
code .
```

In the Java Projects view (or via Command Palette > Java: Focus on Java Projects View), locate the App (or app) class under your workspace.

In the app.java file:

> 1. Enter the relative path to your inputfile on line 5
> 2. Hit Run. The VS Code console will show either:

```
      Allows water to drain
```

```
      Doesn't allow water to drain
```

## Testing with Sample Files

Repeat the Run step, supplying each sample file name in turn (sample1.txt, sample2.txt, sample3.txt) to verify that your solution produces the expected results.
