class Solution {
    public int minPartitions(String n) {
        int maxDigit = Integer.MIN_VALUE;
        for (char c : n.toCharArray()) {
            int num = c - '0';
            if (num > maxDigit) {
                maxDigit = num;
            }
        }
        return maxDigit;
    }
}