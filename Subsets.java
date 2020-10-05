// Steps: 
//*  Start at first digit, find all possible sets from there and then search at the second one without visiting already visited subsets  *//
// Array contains no duplicates
// the number of subsets for this array are 2^n
// since we need to find all possible solutions and permutations complexity is O(n * 2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(allSubsets, new ArrayList<>(), nums, 0);
        return allSubsets;
    }

    private void backtrack(List<List<Integer>> allSubsets, List<Integer> subset, int[] nums, int start) {
        allSubsets.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(allSubsets, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}