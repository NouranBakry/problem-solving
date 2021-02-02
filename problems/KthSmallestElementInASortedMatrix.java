// first solution using a min heap
// evaluation:  time O(n^2 + klogk), space O(n^2)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                priorityQueue.offer(matrix[i][j]);
            }
        }
        int count = 1;
        while (count < k) {
            priorityQueue.poll();
            count++;
        }
        return priorityQueue.peek();
    }
}
/** binary search approach */