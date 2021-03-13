
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int number : nums) {
            if (number == 1) {
                count++;
                max = Math.max(count, max);
            } else
                count = 0;
        }
        return Math.max(count, max);
    }
}