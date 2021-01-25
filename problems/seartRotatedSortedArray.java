//steps: 
// find rotation pivot
// check if target is greater than or less than
// if less search in first half
// if greater search in second half
// return if the target is the pivot
// return -1 if not found
// complexity O(log n)
class Solution {
    public int search(int[] nums, int target) {
        int pivot = 0;
        int l = nums.length-1;
        while(l!=0){
            if(nums[l]< nums[l-1]){
                pivot = l-1;
            }
            l--;
        }
        if(target == nums[pivot]){
            return pivot;
        }
        if(target<=nums[pivot]){
            for(int i=0; i<pivot;i++){
                if(nums[i] == target){
                    return i;
                }
            }
        }
        for(int i=pivot;i<nums.length;i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
