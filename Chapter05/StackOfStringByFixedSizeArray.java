public class StackOfStringByFixedSizeArray {

    private String[] s;
    private int top = 0;

    public StackOfStringByFixedSizeArray(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void pop() {
        if (isEmpty()) {
            throw new Exception("The stack is null");
        }
        String item = s[top-1];
        s[top-1] = null;
        top--;
    }

    public String push(String item) {
        if (top == s.length) {
            throw new Exception("The stack is full");
        }
        s[top] = item;
        top++;
    }
}
