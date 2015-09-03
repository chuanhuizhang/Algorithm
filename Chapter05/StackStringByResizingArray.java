public class StackOfStringByResizingArray {
    private String[] s;
    private int top = 0;

    public StackOfStringByResizingArray() {
        s = new String[1];
    }

    public void push(String item) {
        if (top == s.length) {
            resize(2 * s.length);
        }
        s[top] = item;
        top++;
    }

    public String pop() {
        if (isEmpty()) {
            throw new Exception("The stack is null");
        }
        String item = s[top-1];
        top--;
        if(top > 0 && top == s.length/4) {
            resize(s.length/4);
        }
    }

    private boolean isEmpty() {
        return top == 0;
    }

    private void resize(int capacity) {
        String sNew = new String[capacity];
        for (int i = 0; i < top; i++) {
            sNew[i] = s[i];
        }
        s = sNew;
    }
}
