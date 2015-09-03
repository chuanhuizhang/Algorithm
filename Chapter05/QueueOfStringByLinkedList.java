public class QueueOfStringByLinkedList {

    private Node first = null;
    private Node last = null;

    public QueueOfStringByLinkedList() {

    }

    public class Node {
        public String item;
        public String next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new Exception("The queue is null");
        }
        item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}
