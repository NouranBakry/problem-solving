// using space O(n)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < n + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
// using space O(1) using bit manipulation XOR
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n ; i++) {
            n = n ^ i ^ nums[i];
        }
        return n;
    }
}