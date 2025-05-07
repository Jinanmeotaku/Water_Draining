// weighted quick union find implementation 
// with path compression and union by size
// to find the root of a node and to merge two trees


public class weightedQuickUnionFind {
    private int[] parent;   // parent[i] is the parent of i
    private int[] size;     // size[i]   is the number of nodes in tree rooted at i

    // Constructor: initialize N elements (0 through N–1)
    public weightedQuickUnionFind(int N) {
        parent = new int[N];
        size   = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;  // each node is its own root
            size[i]   = 1;  // tree size = 1
        }
    }

    // find the root of p 
    public int root(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    // checks if p and q in the same component
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // merge the trees containing p and q
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) return;

        // attach smaller tree under larger tree’s root
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];

        // attach larger tree under smaller tree’s root
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
}
