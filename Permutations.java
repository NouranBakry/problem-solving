// slow solution DFS
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        if(nums.length==1){
            output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return output;
        }
        Set<List<Integer>> set = new HashSet<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> currentPermutation = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        stack.push(currentPermutation);
        while(!stack.isEmpty()){
            currentPermutation = stack.pop();
            int [] arr = currentPermutation.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
            for(int i=0;i<arr.length-1;i++){
                swap(arr,i,i+1); 
                if(!set.contains(Arrays.stream(arr).boxed().collect(Collectors.toList()))){
                    stack.push(Arrays.stream(arr).boxed().collect(Collectors.toList()));                                       set.add(Arrays.stream(arr).boxed().collect(Collectors.toList());                                           output.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
                }
            }
        }
        return output;
    }
    
    public void swap(int[] arr, int i, int j){
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
 			List<List<Integer>>  permutations) {
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
 			List<List<Integer>>  permutations) {
        Set<List<Integer>> used = new HashSet<>();
		if (permutation.size() == nums.length) {
			permutations.add(permutation);
			return;
		}
		for (int i = 0; i <= permutation.size(); i++) {
    List<Integer> newPermutation = new ArrayList<>(permutation);
            if(!used.contains(newPermutation)){
			newPermutation.add(i, nums[start]);
			collectPermutations(nums, start + 1, newPermutation, permutations);
            used.add(newPermutation);
            }

		}
	}
}