class Queue {

    static class QueueNode {
        int key;
        QueueNode next;

        QueueNode(int key) {
            this.key = key;

        }
    }

    QueueNode head, tail;

    public Queue() {
        this.head = this.tail = null;
    }

    public void enqueue(int key) {
        QueueNode newNode = new QueueNode(key);
        if (this.head == null) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public void dequeue() {
        if (this.head == null) {
            return;
        } else {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
        }
    }
}