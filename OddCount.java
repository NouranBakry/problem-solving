class Solution {
    public int countOdds(int low, int high) {
        int oddCount = 0;
        if (low % 2 == 0 && high % 2 == 0) {
            oddCount = (high - low) / 2;
        }
        if (low % 2 != 0 && high % 2 == 0) {
            oddCount = (high - (low + 1)) / 2 + 1;
        }
        if (low % 2 == 0 && high % 2 != 0) {
            oddCount = ((high - 1) - low) / 2 + 1;
        }
        if (low % 2 != 0 && high % 2 != 0) {
            oddCount = ((high - 1) - (low + 1)) / 2 + 2;
        }
        return oddCount;
    }
}