# System Tables

## Basic symbol table

### API
```
public class ST<KEY, VALUE>
    ST()
    void put(Key key, Value value)
    Value get(Key key)
    void delete(Key key)
    boolean contains(Key key)
    boolean isEmpty()
    int size()
    Iterable<Key> keys()
```
### Implementations

#### Sequential search in a linked list
Maintain an (unordered) linked list of key-value pairs

#### Binary search in an ordered array
Maintain an ordered array of key-value pairs.

##### Binary search: Jave implementation
Get the rank of the key first, the get the value by index return from rank
```
public Value get(Key key) {
    if (isEmpty()) return null;
    int i = rank(key);
    if (i < N && Keys[i].compareTo(key) == 0) return values[i];
    else return null;
}
private int rank(Key key) {
    int lo = 0, hi = N-1;
    while(lo <= hi) {
        int mid = lo + (hi-lo)/2;
        int cmp = key.compareTo(Keys[mid]);
        if (cmp < 0) hi = mid - 1;
        else if (cmp > 0) lo = mid + 1;
        else return mid;
    }
    return lo;
}
```

## Ordered Symbol table

### API
```
public class ST<Key extends Comparable<Key>, Value>
    ST()
    void put(Key key, Value value)
    Value get(Key key)
    void delete(Key key)
    boolean contains(Key key)
    boolean isEmpty()
    int size()
    Key min()
    Key max()
    Key floor(Key key) // largest key less than or equal to key
    Key ceiling()  // smallest key greater than or equal to key
    int rank(Key key)
    select(int k)  //key of rank k
    void deleteMin()
    void deleteMax()
    int size(Key lo, Key hi)
    Iterable<Key> keys(Key lo, Key hi)  // keys in [lo..hi], in sorted order
    Iterable<Key> keys()  //all keys in the table, in sorted order
```

## Binary Search Trees
A BST is a binary tree in symmetric order
Symetric order. Each node has a key, and every node's key is:</br>
 --Larger than all keys in its left subtree</br>
 --Smaller than all keys in its right subtree

### BST representation in Java
A BST a reference to a root Node.
```
private class Node {
    private Key key;
    private Value vale;
    private Node left, right;
    public Node(Key key, Value val) {
        this.key = key;
        this.value = value;
    }
}
```

#### BST Implementation
```
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        // see above
        private int count;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int com = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void delete(Key key) {}

    public Iterable<Key> iterator() {}
}
```

### Ordered operations
Min, Max, floor, ceiling, size

#### Computring the floor
```
public Key floor(Key key) {
    Node x = floor(root, key);
    if (x == null) return null;
    return x.key;

}

private Node floor(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp = 0) return x;
    if (cmp < 0) return floor(x.left, key);
    Node temp = floor(x.right, key);
    if (temp != null) return temp;
    else return x;
}
```

#### Subtree counts
```
public int size() {
    return size(root);
}

private int size(Node x) {
    if (x == null) return 0;
    return x.count;
}
```

#### Rank
```
public int rank(Key key) {
    return rank(key, root);
}

private int rank(Key key, Node x) {
    if (x == null) return 0;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
        return rank(key, x.left);
    } else if (cmp > 0) {
        return 1 + size(x.left) + rank(key, x.right);
    } else {
        return size(x.left);
    }
}
```
#### Inorder traveral
```
public Iterable<Key> keys() {
    Queue<Key> q = new Queue<Key>();
    indorder(root, q);
    return q;
}

private void inorder(Node x, Queue<Key> q) {
    if (x == null) return;
    inorder(x.left, q);
    q.enqueue(x.key);
    inorder(x.right, q);
}
```

#### Deletion

##### Deleting minmum
```
public void deleteMin() {
    root = deleteMin(root);
}
private Node deleteMin(Node x) {
    if (x.left == null) return x.right;
    x.left = deleteMin(x.left);
    x.count = 1 + size(x.left) + size(x.right);
    return x;
}
```
##### Hibbard deletion
```
public void delete(Key key) {
    root = delete(root, key);
}

private Node delete(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) x.left = delete(x.left, key);
    else if (cmp > 0) x.right = delete(x.right, key);
    else {
        if (x.right == null) return x.left;
        if (x.left == null) return x.right;

        Node temp = x;
        x = min(x.right);  // find the minmum in the right substree and make it the new root of the subtree
        x.right = deleteMin(temp.right); //move all the other nodes in the right subtree of minmum
        x.left = temp.left;
    }
    x.count = size(x.left) + size(x.right) + 1;
    return x;
}






