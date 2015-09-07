public class QuickSort {
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            //Find a[i] that is greater than a[lo]
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }

            //Find a[j] that is less than a[hi]
            while (less(a[hi], a[--j])) {
                if (j == lo) break; // "j == lo" is redundant, because j >= i and i > lo
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] a) {
        /**
         * Todo:
         *      Shuffle the array to sort, to get rid of the sorted case,
         *      because in sort case, all the elements will be exchanged
         **/
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        /*
            if (hi <= lo + CUTOFF -1) {
                //Insertion.sort(a, lo, hi);
                return;
            }
        */

        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
}
