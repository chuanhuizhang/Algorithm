public class Heap {
    public static void sort(Comparable[] a) {
        int N = a.length;
        // create max-heap
        for (int i = N/2; i >= 1; i--) {
            sink(a, i, N);
        }
        // remove the root(max) from the heap
        while(N > 1) {
            exch(a, 1, N);
            N--;
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2k <= N) {
            int j = 2k;
            if (j < N && less(a, j, j+1)) {
                j = j + 1;
            }
            if (less(a, k, j)) {
                exch(a, k, j);
                k = j;
            } else {
                break;
            }
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[i]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = a[i];
    }
}
