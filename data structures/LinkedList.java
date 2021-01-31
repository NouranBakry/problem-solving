public class LinkedList {
    static Node head;

    static class Node {

        Node next;
        int data;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void insertNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        /*
         * reverse the rest list and put the first element at the end
         */
        Node rest = reverse(head.next);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

    public static void main(String[] args) {
        insertNode(20);
        insertNode(4);
        insertNode(15);
        insertNode(85);
    }
}