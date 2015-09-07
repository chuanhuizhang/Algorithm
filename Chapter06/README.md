## Merge Sort

### Basic plan
#### Divide array into two halves.
#### Recursively sort each half.
#### Merge two halves.

### Merging: Java implementation
```
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo, k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }
```
### Sorting: Java implementation
```
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo => hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
```

### Analysis
Mergesort uses extra space proprotional to N

### Practical improvements:
#### Mergesort has too much overhead for tiny subarrays, Cutoff to insertion sort for about 7 items.
#### Stop merge if alreay sorted.
```
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo + CUTOFF -1) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if (less(a[mid+1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }
```

### Bottom-up mergesort: non-recursive
```
public class MergeBU {
    private static void merge(...) {...}

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz) {
            for (int lo = 0; lo < N-sz; lo += sz+sz) {
                merge (a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
}
```

### Comparator
public interface Comparator<Key> {
    int compare(Key, v, Key w)
}
Arrays.sort(a, BY_NAME);

### Stability
A stable sort preserve the relative order of items with equal keys.
Insertion sort and mergesort are stable, but selection or shellsort not.

## Quick Sort
```
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
```
### Improvements
#### Insertion sort small subarrays
```
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + CUTOFF -1) {
            //Insertion.sort(a, lo, hi);
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
```
#### Median: best choice of pivot item = median
```
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;

        int m = mdianOf3(a, lo, lo + (hi - lo)/2, hi);
        swap(a, lo, m);

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
```
## Quick Select
```
// find the kth smallest item
public static Comparable select(Comparable[] a, int k) {
    //Shuffle the array
    int lo = 0;
    int hi = a.length - 1;
    while (hi > lo) {
        int j = partition(a, lo, hi);
        if (j < k) lo = j + 1;
        else if (j > k) hi = j -1;
        else return a[k];
    }
    return a[k];
}
```

## 3-way Quicksort for duplicate keys
```
public static void sort(Comparable[] a, int lo, int hi) {
    if (lo <= hi) return;
    int lt = lo;
    int gt = hi;
    int i = lo;
    Comparable v = a[lo];
    while(i <= gt) {
        int cpm = a[i].compareTo(v);
        if (cmp < 0) {
            exch(a, lt++, i++);
        } else if (cmp > 0) {
            exch(a, gt--, i++);
        } else {
            i++;
        }
    }
    sort(a, lo, lt-1);
    sort(a, gt+1, hi);
}



