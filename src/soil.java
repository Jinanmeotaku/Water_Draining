import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class soil {
    private int n;                   // grid dimension
    private int[][] grid;            // holds 0/1 from the file
    private weightedQuickUnionFind uf; // our UF structure
    private final int virtualTop;    // index n*n
    private final int virtualBottom; // index n*n + 1

    // Constructor: parse file and set up unions
    public soil(String filepath) throws Exception {
        Scanner scanner = new Scanner(new File(filepath));
        ArrayList<int[]> rows = new ArrayList<>();

        // Read each nonempty line, split on whitespace, parse ints
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split("\\s+");    // regex: one or more spaces
            int[] row = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Integer.parseInt(tokens[i]);
            }
            rows.add(row);
        }
        scanner.close();

        n = rows.size();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = rows.get(i);
        }

        // Create UF of size n*n + 2 (two virtual nodes)
        uf = new weightedQuickUnionFind(n*n + 2);
        virtualTop    = n*n;
        virtualBottom = n*n + 1;

        connectOpenCells();
    }

    // Map 2D (row,col) → 1D index in UF
    private int index(int row, int col) {
        return row * n + col;
    }

    // Connect every open cell to its open neighbors and to virtual nodes
    private void connectOpenCells() {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != 1) continue;
                int idx = index(row, col);

                // top row → virtualTop
                if (row == 0) {
                    uf.union(idx, virtualTop);
                }
                // bottom row → virtualBottom
                if (row == n - 1) {
                    uf.union(idx, virtualBottom);
                }

                // union with up, down, left, right if open
                if (row > 0 && grid[row-1][col] == 1) {
                    uf.union(idx, index(row-1, col));
                }
                if (row < n - 1 && grid[row+1][col] == 1) {
                    uf.union(idx, index(row+1, col));
                }
                if (col > 0 && grid[row][col-1] == 1) {
                    uf.union(idx, index(row, col-1));
                }
                if (col < n - 1 && grid[row][col+1] == 1) {
                    uf.union(idx, index(row, col+1));
                }
            }
        }
    }

    // True if there’s any path of 1’s from top to bottom
    public boolean doesDrain() {
        return uf.connected(virtualTop, virtualBottom);
    }
}
