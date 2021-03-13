// first approach
// sort then get 3rd max
// complexity O(nlogn)
// space O(n)
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] sorted = new int[set.size()];
        int i = 0;
        for (int num : set) {
            sorted[i] = num;
            i++;
        }
        int n = sorted.length;
        if (n < 3) {
            return sorted[n - 1];
        }
        return sorted[n - 3];
    }
}

// Priority Queue O(N) space and time
class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            if(!heap.contains(num)){
                heap.offer(num);
                if(heap.size() > 3){
                    heap.poll();
                }
            }
        }
        if(heap.size()<3){
            while(heap.size()>1){
                heap.poll();
            }
        }
        return heap.peek();

    }
}
// O(n) space and time
class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num: nums){
            if(num > first){
                third = second;
                second = first;
                first = num;
            } else if(num < first && num > second){
                third = second;
                second = num;
            } else if(num < second && num > third){
                third = num;
            }
        }
        if(third == Long.MIN_VALUE){
            return (int)first;
        } else return (int)third;
    }
}