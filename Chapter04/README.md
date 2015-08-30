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

#### CCW(Counterclockwis)
```
public class Point2D {
    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    ...


    public static int ccw(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.x - a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
        if (area2 < 0) return -1; // clockwise
        else if (area2 > 0) return +1; // counter-clockwise
        else return 0; // collinear
    }
}


