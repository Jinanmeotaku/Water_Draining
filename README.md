# Water Drainage Checker

This Java project implements the Weighted Quick Union (union-find) algorithm to determine whether water can percolate from the top row of a soil grid to the bottom row.

## Prerequisites

- Java JDK 8 or higher installed.  
- VS Code with the Java Extension Pack.
- alg4.jar 

## Project Structure


almaliky_jinan_project1/
├── src/
│ ├── app.java # Main class containing public class App
│ ├── soil.java # Soil parser & percolation logic
│ └── weightedQuickUnionFind.java # UF implementation
├── sample1.txt # Test input file
├── sample2.txt # Test input file
├── sample3.txt # Test input file
└── README.md


- **src/**: contains `.java` source files  
- **sample*.txt**: example soil grids for testing

## Building (Terminal)

From the project root in your terminal for 
running in VS Code, Open the project folder in VS Code:


```bash
code .
```

In the Java Projects view (or via Command Palette > Java: Focus on Java Projects View), locate the App (or app) class under your workspace.

Right-click the Run icon next to the class name.

In the app.java file; 
- enter the relative path to your inputfile on line 5 

- Hit Run. The VS Code console will show either:

    **Allows water to drain**

  or


    **Doesn't allow water to drain**


## Testing with Sample Files
Repeat the Run step, supplying each sample file name in turn (sample1.txt, sample2.txt, sample3.txt) to verify that your solution produces the expected results.

