# Comparable Interface

```
public interface Comparable<Item> {
    public int compareTo(Item that)
}
```

### For example,
```
public class File implements Comparable<File> {
    ...
    public int compareTo(File b) {
        ...
        return -1;
        ...
        return +1;
        ...
        return 0;
    }
}
```
### Insersion Sort implementation
```
public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
        for (int j = i; j > 0; j--) {
            if (a[j].compareTo(a[j-1]) < 0)
                exch(a, j, j-1);
            else break;
        }
    }
}
```
### Helper functions
#### less
```
private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
}
```
#### swap/exch
```
private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}
```
#### isSorted
```
private static boolean isSorted(Comparable[] a) {
    for(int i = 1; i < a.length; i++) {
        if (less(a[i], a[i-1])) return false;
    return true;
    }
}
```
