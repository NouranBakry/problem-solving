class Solution {
    public int tupleSameProduct(int[] nums) {
        int count = 0;
        if (nums.length < 4) {
            return count;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                int productCount = map.getOrDefault(product, 0);
                count += 8 * productCount;
                map.put(product, productCount + 1);
            }
        }
        return count;
    }
}