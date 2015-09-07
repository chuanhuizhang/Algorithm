public class MergeSort {
    private static void merge(Comparable[] a, Comparable aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        int i = lo, j = mid+1;

        for (int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = 0; k <= hi; k++) {
            if (i > mid)        a[k] = a[j++];
            else if (j > hi)    a[k] = a[i++];
            else if (less(a[j], a[i]))  a[k] = a[j++];
            else                a[k] = a[i++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        int lo = 0, hi = a.length - 1;
        Comparable aux = new Comparable[a.length]
        sort(a, aux, lo, hi);
    }
}
