class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
                continue;
            }
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                if (nums[p1] + nums[p2] == 0 - nums[i]) {
                    output.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    p1++;
                    p2--;
                    while (p1 < p2 && nums[p1] == nums[p1 - 1])
                        p1++;
                    while (p1 < p2 && nums[p2] == nums[p2 + 1])
                        p2--;
                } else if (nums[p1] + nums[p2] < 0 - nums[i]) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }
        return new ArrayList(output);
    }
}