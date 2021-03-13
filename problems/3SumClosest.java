class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int difference = Integer.MAX_VALUE;
        int closestToTarget = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (Math.abs(target - (nums[i] + nums[j] + nums[k])) < Math.abs(difference)) {
                    difference = target - (nums[i] + nums[j] + nums[k]);
                    closestToTarget = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else
                    k--;
            }
        }
        return closestToTarget;
    }
}