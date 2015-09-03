public class QueueOfStringByResizeArray {

    private String[] s;
    private int head = 0;
    private int tail = 0;

    public QueueOfStringByResizeArray() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(String item) {
        if (tail == s.length) {
            resize(2 * s.length);
        }
        s[tail] = item;
        tail++;
    }

    public String dequeue() throws Exception{
        if (isEmpty()) {
            throw new Exception("The queue is null");
        }
        String item = s[head];
        s[head] = null;
        head++;
        if (tail-head == 0) {
            s = new String[1];
        } else if ((tail-head) > 0 && (tail - head) == s.length/4) {
            resize(s.length/4);
        }
        return item;
    }

    public void resize(int capacity) {
        String[] sNew = new String[capacity];
        for (int i = head; i < tail; i++) {
            sNew[i-head] = s[i];
        }
        tail = tail - head;
        head = 0;
        s = sNew;
    }

    public void showAll() {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            QueueOfStringByResizeArray queueArray = new QueueOfStringByResizeArray();
            System.out.println(queueArray.isEmpty());
            queueArray.enqueue("hi");
            queueArray.enqueue("world");
            queueArray.enqueue("world");
            queueArray.enqueue("world");
            queueArray.enqueue("world");
            queueArray.showAll();
            System.out.println("dequeue: " + queueArray.dequeue());
            queueArray.showAll();
            System.out.println("dequeue: " + queueArray.dequeue());
            queueArray.showAll();
            System.out.println("dequeue: " + queueArray.dequeue());
            queueArray.showAll();
            System.out.println("dequeue: " + queueArray.dequeue());
            queueArray.showAll();
            System.out.println("dequeue: " + queueArray.dequeue());
            queueArray.showAll();
            System.out.println("dequeue: " + queueArray.dequeue());
            queueArray.showAll();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
