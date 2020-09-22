import java.util.*;

/*
example: [2,3,6,7], target=7, solution=[[7],[2,2,3]]
\Steps: 
1. 
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        int i = 0;
        while (i < candidates.length && target - candidates[i] >= 0) {
            List<Integer> combination = new ArrayList<>();
            if (candidates[i] == target) {
                combination.add(target);
            }

            output.add(combination);
        }
        return output;
    }
}
