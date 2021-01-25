
// slow solution
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        if (nums.length == 0) {
            return allPermutations;
        }
        Set<List<Integer>> permutations = new HashSet<>();
        collectPermutations(nums, 0, new ArrayList<>(), permutations);
        for (List<Integer> list : permutations) {
            allPermutations.add(list);
        }
        return allPermutations;
    }

    private void collectPermutations(int[] nums, int start, List<Integer> permutation,
            Set<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(permutation);
            return;
        }
        for (int i = 0; i <= permutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[start]);
            collectPermutations(nums, start + 1, newPermutation, permutations);
        }
    }
}
// using a set

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        if (nums.length == 0) {
            return allPermutations;
        }
        collectPermutations(nums, 0, new ArrayList<>(), allPermutations);
        return allPermutations;
    }

    private void collectPermutations(int[] nums, int start, List<Integer> permutation,
            List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(permutation);
            return;
        }
        for (int i = 0; i <= permutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[start]);
            collectPermutations(nums, start + 1, newPermutation, permutations);
        }
    }
}