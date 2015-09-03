public class WeightedQuickUnionUF {

    private int[] parent; // parent[i] = parent of i
    private int[] size; // size[i] = number of objects in subtree rooted at i
    private int count; // number of components

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1
     * @param N the number of objects
     * @throws java.lang.IllegalArgumentException if N < 0
     **/
    public WeightedQuickUnionUF(int N) {
        parent = new int[N];
        size = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Return the number of components
     * @return the number of components (between 1 and N)
     **/
    public int count() {
        return count;
    }

    /**
     * Return the component identifier for the componenet containing site p
     * @param p the integer representing one site
     * @return the component identifier for the componenet containing site p
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     **/
    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * Validate that p is a valid index
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     **/
    public void validate(int p) {
        int N = parent.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + "is not between 0 and " + N);
        }
    }

    /**
     * Are the two sites p and q in the same component
     * @param p the integer representing one site
     * @param q the integer representing one site
     * @return true if the two sites p and q are in the same component, and false otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     **/
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return parent[p] == parent[q];
    }

    /**
     * Merge the component containing site p with the component containing site q
     * @param p the integer representing one site
     * @param q the integer representing one site
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     **/
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int root_p = find(p);
        int root_q = find(q);
        if (root_p == root_q) return;
        if (size[root_p] < size[root_q]) {
            parent[root_p] = root_q;
            size[root_q] += size[root_p];
        } else {
            parent[root_q] = root_p;
            size[root_p] += size[root_q];
        }
        count--;
    }
}
