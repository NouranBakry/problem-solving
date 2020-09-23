class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // sort the array
        Arrays.sort(arr);
        int diff = 0;
        diff = arr[1] - arr[0];
        if (arr.length > 2) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] - arr[i] != diff) {
                    return false;
                }
            }
        }
        return true;
    }
}