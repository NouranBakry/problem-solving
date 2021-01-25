/**
 * Soltution: attempt: loop on 2n and have two pointers and shuffle and add into
 * a new array evaluation: O(2n) -> O(n) optimization: space O(n) -> O(1)
 * How?
 * 
 * 
 */

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffledArray = new int[2 * n];
        int x = 0;
        int y = n;
        int i = 0;
        while (x < n && y < 2 * n && i < 2 * n) {
            shuffledArray[i] = nums[x];
            shuffledArray[i + 1] = nums[y];
            i = i + 2;
            x = x + 1;
            y = y + 1;
        }
        return shuffledArray;
    }
}
