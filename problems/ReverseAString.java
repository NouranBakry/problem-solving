// 1st solution
class Solution {
    public void reverseString(char[] s) {
        String reversed = "";
        int n = s.length;
        for (int i = n - 1; i >= 0; i--) {
            reversed += s[i];
        }
        int j = 0;
        for (char c : reversed.toCharArray()) {
            s[j] = c;
            j++;
        }
    }
}

// 2nd solution
// The solution below complexity is
// Time: O(n)
// Space: O(1)
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
