// implementing a stack using an array

public class Stack {
    int top;
    static final int MAX = 1000;
    int[] a = new int[MAX];

    public Stack() {
        top = -1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            top++;
            a[top] = x;
            return true;
        }
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top--];
        }
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top];
        }
    }
}

// implementing a stack using a linkedlist

public class StackAsLinkedList {
    StackNode root;

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);
        if (root == null) {
            root = newNode;
        } else {
            StackNode temp = root;
            root = newNode;
            newNode.next = temp;
        }
    }

    public int pop() {
        int popped = Integer.MIN_VALUE;
        if (root != null) {
            popped = root.data;
            root = root.next;
        } else {
            System.out.println("Stack Underflow");
        }
        return popped;
    }

    public int peek() {
        if (root == null) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        } else {
            return root.data;
        }
    }
}