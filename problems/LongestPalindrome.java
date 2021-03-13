/**
 * Input: s = "babad" Output: "bab" Note: "aba" is also a valid answer. Input:
 * s= "cbbd" Output: "bb"
 */
// expand around the center
// Time O(n^2)
// Space O(1)
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expand(String s, int left, int right) {
        if (s.isEmpty() || s == null) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
// example 
// ababaaba
// at i = 0 a no expansion
// at i = 1 