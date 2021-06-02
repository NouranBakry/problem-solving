class Solution {
    int[] originalArr;
    int[] copy;
    public Solution(int[] nums) {
        originalArr = nums.clone();
        copy = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
		for (int i = 0; i < copy.length; i++) {
			int randomIndexToSwap = rand.nextInt(copy.length);
			int temp = copy[randomIndexToSwap];
			copy[randomIndexToSwap] = copy[i];
			copy[i] = temp;
		}
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */