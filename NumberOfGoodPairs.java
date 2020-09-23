class Solution {
    public int numIdenticalPairs(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            count += map.get(n) - 1;
        }

        return count;
    }
}