package com.chapter05;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node first = null;

    public class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("The stack is empty");
        }
        Item item = first.item;
        first = first.next;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {}

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public void showAll() {
        Iterator<Item> iterator = iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try{
            Stack<String> stack = new Stack<String>();
            stack.push("hi");
            stack.push("hi");
            stack.push("hi");
            stack.push("hi");
            stack.push("hi");
            stack.showAll();
            stack.pop();
            stack.pop();
            stack.showAll();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
