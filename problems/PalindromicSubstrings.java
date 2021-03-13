// Time complexity O(n^2)
// space complexity O(1)
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += getPossiblePalindromesCount(s, i, i);
            count += getPossiblePalindromesCount(s, i, i + 1);
        }
        return count;
    }

    public int getPossiblePalindromesCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
            count++;
        }
        return count;
    }
}
// dynamic programming
