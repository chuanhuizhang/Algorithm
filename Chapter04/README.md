# Comparable interface

```
public interface Comparable<Item> {
    public int compareTo(Item that)
}
```

## For example,
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
