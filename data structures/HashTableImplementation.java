/**
 * the methods we need to have here are put(Key, value), get(key), remove(key)
 * We need a hash function, a function that gets the index of each in the array
 * 
 */

class MyHashMap {

    /** Initialize your data structure here. */
    private final int capacity = 10000;
    private final ListNode[] nodes = new ListNode[capacity];

    public MyHashMap() {

    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode findElement(int index, int key) {
        if (nodes[index] == null) {
            return nodes[index] = new ListNode(-1, -1);
        }
        ListNode previous = nodes[index];
        while (previous.next != null && previous.next.key != key) {
            previous = previous.next;
        }
        return previous;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode previous = findElement(index, key);
        if (previous.next == null) {
            previous.next = new ListNode(key, value);
        } else {
            previous.next.value = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        return prev.next == null ? -1 : prev.next.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private static class ListNode {
        int key, value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */