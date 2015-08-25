public class Percolation  {
    //create N-by-N grid, with all sites blocked
    private int[][] id;

    public Percolation(int N) {
        id = new int[N][N];
        for(int row=0; row<N; row++) {
            for(int column=0; column<N; column++) {
                id[row][column] = row * N + column;
            }
        }
    }
    //open site (row i, column j) if it is not already open
    public void open(int i, int j) {
        //open itself by setting the value be -1
        //check if neighbors are open, if yes, connect
        this.id[i-1][j-1] = -1;

    }
    //is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        return this.id[i-1][j-1] == -1;
    }
    //is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        if (i == 1) return true;

        return true;
    }
    // does the system percolate
    public boolean percolate() {
        return true;
    }

    public void print() {
        for(int i = 0; i < id.length; i++) {
            for(int j = 0; j < id.length; j++) {
                System.out.print(id[i][j] + "\t");
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(10);
        p.open(2,3);
        p.print();
    }
}
