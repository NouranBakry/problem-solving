class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int backward = n - 1;
        int forward = 0;
        int newSize = 0;
        while (forward <= backward) {
            if (backward - forward != 1) {
                // shift
                for (int j = forward; j < n; j++) {
                    nums[j] = nums[j + 1];
                }
                // replace the end with zero
                nums[n - 1] = -1;
            }
            forward++;
            backward--;
        }
        forward = 0;
        while (forward < n) {
            if (nums[forward] < 0) {
                newSize++;
            }
        }
        return newSize;
    }
}