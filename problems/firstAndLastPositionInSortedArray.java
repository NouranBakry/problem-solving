//Steps:
// Divide the array into two
// search in each half
// add indices in resulting array

import java.util.*;
class Solution{
    public int[] searchRange(int[] nums, int target){
        if(nums.length==0){
            return new int[] {-1,-1};
        }
        List<Integer> list = new ArrayList<>();
        int pivot = (nums.length-1)/2;
        if(target <= nums[pivot]){
            for(int i=0; i<pivot;i++){
                if(nums[i]==target){
                    list.add(i);
                }
            }
                        if(target == nums[pivot]){
                list.add(pivot);
            }
        }
        for(int i=pivot+1;i<nums.length;i++){
            if(nums[i]==target){
                    list.add(i);
            }
        }
        if (list.isEmpty()){
            return new int[] {-1,-1};
        }
        if (list.size() == 1){
            return new int[]{list.get(0), list.get(0)};
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}