/**
 * Every operation takes constant time in the worst case
 **/
public class StackOfStringByLinkedList {

    private Node first = null;

    public class Node {
        String item;
        Node next;
    }

    public boolean isEmplty() {
        return first == null;
    }

    public String pop(){
        if (isEmplty()) {
            throw new Exception("Stack is null");
        }
        String item = first.item;
        first = first.next;
        return item;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
}
