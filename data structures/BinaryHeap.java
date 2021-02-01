// min heap
/**
 * operations: insert, extract min, heapifyUp (bubble up), heapifyDown(bubble
 * down)
 */

// max heap: same just the reverse ;)
/** MIN HEAP */
class Heap {
    int capacity = 10;
    int size = 0;
    int[] heapArray = new int[capacity];

    public void insert(int x) {
        if (size == 0) {
            throw new IllegalStateException();
        }
        size++;
        heapArray[size - 1] = x;
        heapifyUp();
    }

    // extracts minimum element and removes it from the array
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int minElement = heapArray[0];
        swap(0, size - 1);
        heapArray[size - 1] = 0;
        size--;
        heapifyDown();
        return minElement;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        } else
            return heapArray[0]; // root and min element
    }

    public int getLeftChildIndex(int index) {
        return (index + 1) * 2;
    }

    public int getRightChildIndex(int index) {
        return (index + 1) * 2 + 1;
    }

    public int getParentIndex(int index) {
        return (index + 1 / 2) - 1;
    }

    public int getLeftChild(int index) {
        if (hasLeftChild(index)) {
            int leftChildIndex = (index + 1) * 2;
            return heapArray[leftChildIndex];
        } else
            throw new IllegalStateException();
    }

    public int getRightChild(int index) {
        if (hasRightChild(index)) {
            int rightChildIndex = (index + 1) * 2;
            rightChildIndex += 1;
            return heapArray[rightChildIndex];
        } else
            throw new IllegalStateException();
    }

    public int getParent(int index) {
        if (hasParent(index)) {
            int parentIndex = (index + 1) / 2;
            return heapArray[parentIndex];
        } else
            throw new IllegalStateException();
    }

    public boolean hasLeftChild(int index) {
        int leftChildIndex = (index + 1) * 2;
        return (leftChildIndex > index && leftChildIndex < size);
    }

    public boolean hasRightChild(int index) {
        int rightChildIndex = (index + 1) * 2;
        rightChildIndex += 1;
        return (rightChildIndex > index && rightChildIndex < size);
    }

    public boolean hasParent(int index) {
        int parentIndex = (index + 1) / 2;
        return (parentIndex < index && parentIndex < size);
    }

    public void swap(int first, int second) {
        int temp = heapArray[first];
        heapArray[first] = heapArray[second];
        heapArray[second] = temp;
    }

    public void checkCapacity(int size) {
        if (size > capacity) {
            heapArray = Arrays.copyOf(heapArray, capacity * 2);
            capacity *= 2;
        }
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > heapArray[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int root = 0;
        while (hasLeftChild(root)) {
            // assume smaller child is the left child
            int smallerChild = getLeftChildIndex(root);
            if (hasRightChild(root) && getRightChild(root) > getLeftChild(root)) {
                smallerChild = getRightChildIndex(root);
            }
            if (heapArray[smallerChild] < heapArray[root]) {
                swap(root, smallerChild);
            }
            root = smallerChild;
        }
    }
}

/**
 * MAX HEAP
 */

class Heap {
    int capacity = 10;
    int size = 0;
    int[] heapArray = new int[capacity];

    public void insert(int x) {
        if (size == 0) {
            throw new IllegalStateException();
        }
        size++;
        heapArray[size - 1] = x;
        heapifyUp();
    }

    // extracts maximum element and removes it from the array
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int maxElement = heapArray[0];
        swap(0, size - 1);
        heapArray[size - 1] = 0;
        size--;
        heapifyDown();
        return maxElement;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        } else
            return heapArray[0]; // root and max element
    }

    public int getLeftChildIndex(int index) {
        return (index + 1) * 2;
    }

    public int getRightChildIndex(int index) {
        return (index + 1) * 2 + 1;
    }

    public int getParentIndex(int index) {
        return (index + 1 / 2) - 1;
    }

    public int getLeftChild(int index) {
        if (hasLeftChild(index)) {
            int leftChildIndex = (index + 1) * 2;
            return heapArray[leftChildIndex];
        } else
            throw new IllegalStateException();
    }

    public int getRightChild(int index) {
        if (hasRightChild(index)) {
            int rightChildIndex = (index + 1) * 2;
            rightChildIndex += 1;
            return heapArray[rightChildIndex];
        } else
            throw new IllegalStateException();
    }

    public int getParent(int index) {
        if (hasParent(index)) {
            int parentIndex = (index + 1) / 2;
            return heapArray[parentIndex];
        } else
            throw new IllegalStateException();
    }

    public boolean hasLeftChild(int index) {
        int leftChildIndex = (index + 1) * 2;
        return (leftChildIndex > index && leftChildIndex < size);
    }

    public boolean hasRightChild(int index) {
        int rightChildIndex = (index + 1) * 2;
        rightChildIndex += 1;
        return (rightChildIndex > index && rightChildIndex < size);
    }

    public boolean hasParent(int index) {
        int parentIndex = (index + 1) / 2;
        return (parentIndex < index && parentIndex < size);
    }

    public void swap(int first, int second) {
        int temp = heapArray[first];
        heapArray[first] = heapArray[second];
        heapArray[second] = temp;
    }

    public void checkCapacity(int size) {
        if (size > capacity) {
            heapArray = Arrays.copyOf(heapArray, capacity * 2);
            capacity *= 2;
        }
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) < heapArray[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int root = 0;
        while (hasLeftChild(root)) {
            // assume larger child is the left child
            int largerChild = getLeftChildIndex(root);
            if (hasRightChild(root) && getRightChild(root) < getLeftChild(root)) {
                largerChild = getRightChildIndex(root);
            }
            if (heapArray[smallerChild] > heapArray[root]) {
                swap(root, smallerChild);
            }
            root = largerChild;
        }
    }
}