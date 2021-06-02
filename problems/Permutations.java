// slow solution DFS
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        if (nums.length == 0) {
            return output;
        }
        permute(nums, 0, new ArrayList<Integer>(), output);
        return output;
    }

    private void permute(int[] nums, int start, List<Integer> permutation, List<List<Integer>> allPermutations){
        if(permutation.size() == nums.length){
            allPermutations.add(permutation);
            return;
        }
        Set<List<Integer>> set = new HashSet<>();
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(permutation);
        while(!stack.isEmpty()){
            List<Integer> currentPermutation = stack.pop();
            for(int i=0;i<currentPermutation.size();i++){
                if(set.add(currentPermutation)){
                List<Integer> newPermutation = new ArrayList<>(permutation);
                swap(nums,start,i); 
                stack.push(newPermutation);
                permute(nums, start+1, newPermutation, allPermutations);
                                                  
                }
            }
        }
 
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Bottom up recursive approach
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.length == 0) {
            return permutations;
        }
        collectPermutations(nums, 0, new ArrayList<>(), permutations);
        return permutations;
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

// added a "visited" set
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.length == 0) {
            return permutations;
        }
        collectPermutations(nums, 0, new ArrayList<>(), permutations);
        return permutations;
    }

    private void collectPermutations(int[] nums, int start, List<Integer> permutation,
            List<List<Integer>> permutations) {
        Set<List<Integer>> used = new HashSet<>();
        if (permutation.size() == nums.length) {
            permutations.add(permutation);
            return;
        }
        for (int i = 0; i <= permutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            if (!used.contains(newPermutation)) {
                newPermutation.add(i, nums[start]);
                collectPermutations(nums, start + 1, newPermutation, permutations);
                used.add(newPermutation);
            }
        }
    }
}