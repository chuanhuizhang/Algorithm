import edu.princeton.cs.algs4.*;

public class Percolation  {

    private int size;
    private WeightedQuickUnionUF uf;
    private boolean[] percolationArray;

    //create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        this.size = N;
        uf = new WeightedQuickUnionUF((N+1)*(N+1));
        percolationArray = new boolean[(N+1)*(N+1)];
        for (int i=1; i<=N; i++) {
            uf.union(0*N+1, 0*N+i); //Union all the sites in the first row
            uf.union((N+1)*N+1, (N+1)*N+i); //Union all the sites in the last row
            percolationArray[0*N+i] = true;
            percolationArray[(N+1)*N+i] = true;
        }
    }
    //open site (row i, column j) if it is not already open
    public void open(int i, int j) {
        if (i < 1 || i > size) {
            throw new IndexOutOfBoundsException("row index " + i + " out of bounds");
        }
        if (j < 1 || j > size) {
            throw new IndexOutOfBoundsException("row index " + j + " out of bounds");
        }
        if (isOpen(i, j)) return;
        //open itself by setting the value be true
        percolationArray[i*size + j+1] = true;
        //check if neighbors are open, if yes, connect
        //up neighbor
        if (i>1 && this.isOpen(i-1, j)) {
            uf.union((i-1)*size+j, i*size+j);
        }
        //down neighbor
        if (i<size && this.isOpen(i+1, j)) {
            uf.union((i+1)*size+j, i*size+j);
        }
        //left neighbor
        if (j>1 && this.isOpen(i, j-1)) {
            uf.union(i*size+j-1, i*size+j);
        }
        //right neighbor
        if (j<size && this.isOpen(i, j+1)) {
            uf.union(i*size+j+1, i*size+j);
        }
    }
    //is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        if (i < 1 || i > size) {
            throw new IndexOutOfBoundsException("row index " + i + " out of bounds");
        }
        if (j < 1 || j > size) {
            throw new IndexOutOfBoundsException("row index " + j + " out of bounds");
        }
        return percolationArray[i*size+j];
    }
    //is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        if (i < 1 || i > size) {
            throw new IndexOutOfBoundsException("row index " + i + " out of bounds");
        }
        if (j < 1 || j > size) {
            throw new IndexOutOfBoundsException("row index " + j + " out of bounds");
        }
        if (!this.isOpen(i, j))
            return false;
        for (int k = 1; k<=size; k++) {
            if (uf.connected(i*size+j, 0*size+k))
                return true;
        }
        return false;
    }
    // does the system percolate
    public boolean percolate() {
        for (int k = 1; k<=size; k++) {
            if (this.isFull(size+1, k))
                return true;
        }
        return false;
    }

    public void print() {
        System.out.println(uf.count());
        for(int i = 1; i <(size+1)*(size+1); i++) {
            System.out.print(percolationArray[i]);
            System.out.print('\t');
            if(i%size == 0) {
                System.out.print('\n');
            }
        }
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(10);
        p.open(2,2);
        p.open(3,2);
        System.out.println(p.isFull(1,2));
        p.print();
    }
}
