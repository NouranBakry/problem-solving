/**
 * Spcace Complexity O(N) used by the two arrays
 * Time Complexity O(n^2)
 */
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int[] topAndBottomView = new int[length];
        int[] leftAndRightView = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                leftAndRightView[i] = Math.max(leftAndRightView[i], grid[i][j]);
                topAndBottomView[j] = Math.max(topAndBottomView[j], grid[i][j]);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum += Math.min(leftAndRightView[i], topAndBottomView[j]) - grid[i][j];
            }
        }
        return sum;
    }
}