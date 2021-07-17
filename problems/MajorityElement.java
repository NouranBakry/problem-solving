// space O(n) 
// time O(n)

class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int max = 0;
        int majority = 0;
        Map<Integer, Integer> elementsCount = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            elementsCount.put(nums[i], elementsCount.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: elementsCount.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                majority = entry.getKey();
            }
        }
        return majority;
    }
}

