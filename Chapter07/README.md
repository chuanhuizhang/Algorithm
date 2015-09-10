## Priority Queue
Remove the largest(or smallest) item

### APIs
```
public class MaxPQ<Key extends Comparable<Key>>
    MaxPQ()
    MaxPQ(Key[] a)
    void insert(Key v)
    Key delMax() //return and remove the largest key
    boolean isEmpty()
    Key max()
    int size()
```

### Array implementation

#### Unordered array implementation
```
public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public UnorderedMaxPQ(int capacity) {
        pq =(Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        exch(max, N-1);
        return pq[--N];
    }
}
```

### Binary heap
Array representation of a heap-ordered complete binary tree.

#### Proposition
Largest key is a[1], which is root of binary tree. <br/>
Can use array indices to move throught tree </br/>
    Parent of node at k is at k/2 <br/>
    Children of node at k are 2k and 2k+1 <br/>

#### Swim up
```
private void swim(int k) {
    while (k > 1 && less(k/2, k)) {
        exch(k/2, k);
        k = k/2;
    }
}
```

#### Insertion
```
public void insert(Key x) {
    pq[++N] = x;
    swim(N);
}
```

#### Sink down
```
private void sink(int k) {
    while(2k <= N) {
        int j = 2k;
        if (j < N && less(j, j+1)) {
            j += 1;
        }
        if (less (k, j)) {
            exch(k, j);
        } else {
            break;
        }
        k = j;
    }
}
```

#### Delete the maximum
```
public Key delMax() {
    Key max = pq[1];
    exch(1, N);
    N--;
    sink(1);
    pq[N+1] = null; // prevent loitering
    return max;
}
```

### Heapsort
Create max-heap with all N keys<br/>
Repeatedly remove all the maximum key <br/>
Heapsort is optimal for both time and space but not stable

#### First pass
Build heap using bottome-up method
```
// sink all the nodes except the leaf node
for (int k = N/2; k >= 1; k--) {
    sink(a, k, N);
}
```

#### Second pass
Remove the maximum, one at a time<br/>
Leave in array, instead of nulling out <br/>
```
// Move the root to the end of the array, reduce the length of the heap array by 1 each time
while(N > 1) {
    exch(a, 1, N);
    N--;
    sink(a, 1, N);
}
```



