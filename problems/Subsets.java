// Steps: 
//*  Start at first digit, find all possible sets from there and then search at the second one without visiting already visited subsets  *//
// Array contains no duplicates
// the number of subsets for this array are 2^n
// since we need to find all possible solutions and permutations complexity is O(n * 2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output= new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        collectSubsets(output,subResult,nums,0);
        return output;
    }
    private void collectSubsets(List<List<Integer>> allSubs,List<Integer> subResult, int[] nums, int start){
        allSubs.add(new ArrayList<>(subResult));
        for(int i=start; i <nums.length;i++){
            subResult.add(nums[i]);
            collectSubsets(allSubs,subResult,nums,i+1);
            subResult.remove(subResult.size()-1);
        }
    }
}