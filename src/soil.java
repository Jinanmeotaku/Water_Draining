//soil app class that reads a file and checks if the soil allows
//water to drain from top to bottom

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class soil {
    private int n;                   // grid dimension
    private int[][] grid;            // holds 0 and 1 from the file
    private weightedQuickUnionFind uf;   // union find data structure is private because it is not used outside this class
    private final int virtualTop;    // index n*n
    private final int virtualBottom; // index n*n + 1

    // parse file and set up the unions
    public soil(String filepath) throws Exception {
        Scanner scanner = new Scanner(new File(filepath)); // open file
        ArrayList<int[]> rows = new ArrayList<>(); // holds each row of the grid

        // reads each non empty line split on whitespace and parse ints
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split("\\s+");    // one or more spaces
            int[] row = new int[tokens.length];

            for (int i = 0; i < tokens.length; i++) {  
                row[i] = Integer.parseInt(tokens[i]);
            }
            rows.add(row);
        }
        scanner.close();  // close the file

        n = rows.size(); // number of rows in the grid
        grid = new int[n][n]; // initialize the grid

        // fill the grid with 0s and 1s from the file
        for (int i = 0; i < n; i++) {
            grid[i] = rows.get(i);
        }

        // create UF two virtual nodes
        uf = new weightedQuickUnionFind(n*n + 2);

        virtualTop    = n*n;       
        virtualBottom = n*n + 1;

        connectOpenCells();
    }

    // map 2D  1D index in UF
    private int index(int row, int col) {
        return row * n + col;
    }

    // connect every open cell to its open neighbors and to virtual nodes
    private void connectOpenCells() {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != 1) continue;
                int idx = index(row, col);

                // top row 
                if (row == 0) {
                    uf.union(idx, virtualTop);
                }
                // bottom row
                if (row == n - 1) {
                    uf.union(idx, virtualBottom);
                }

                // union with up, down, left, right if open
                if (row > 0 && grid[row-1][col] == 1) {
                    uf.union(idx, index(row-1, col));   // it goes up by 1
                }
                if (row < n - 1 && grid[row+1][col] == 1) {
                    uf.union(idx, index(row+1, col));   // it goes down by 1
                }
                if (col > 0 && grid[row][col-1] == 1) {
                    uf.union(idx, index(row, col-1));   // it goes left by 1
                }
                if (col < n - 1 && grid[row][col+1] == 1) {
                    uf.union(idx, index(row, col+1));   // it goes right by 1
                } 
            }
        }
    }

    // true if there is any path of 1s from top to bottom
    public boolean doesDrain() {
        return uf.connected(virtualTop, virtualBottom);
    }
}
