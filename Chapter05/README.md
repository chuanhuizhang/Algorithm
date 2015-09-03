Stack -> LIFO
Queue -> FIFO

## Stack API
```
void push(String item)
String pop()
boolean isEmpty()
int size()
```


## Queue API
```
void enqueue(String item)
String dequeue()
boolean isEmpty()
int size()
```

## Generic
```
public class Stack<Item> {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }
    ...
    public void pus(Item item) {}
    public Item pop() {}
}
```
### but we can not implement this stack/queue by array, because generic array creation not allowed in java

## Bag API
```
public class Bag<Item> implements Iterable<Item> {
    Bag(){}
    void add(Item x) {}
    int size() {}
    Iterable<Item> iterator(){}
}
```
