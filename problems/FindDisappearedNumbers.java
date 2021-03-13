class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            set.add(num);
        }
        for(int i=1; i<= nums.length+1; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
// another solution
// the numbers in the array are from 1 to n, to find the missing index we can do the trick is flagging all available indices the onees ending up not flagged are missing
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int number: nums){
            if(nums[Math.abs(number) - 1] > 0){
               nums[Math.abs(number) - 1] *= -1; 
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}