/**
 * Solution:
 * 
 * Attempt: Loop on all accounts and add the wealth of each customer and store
 * the maximum. evaluation: O(mn)
 */

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        int m = accounts.length;
        for (int i = 0; i < m; i++) {
            int totalWealthPerCustomer = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                totalWealthPerCustomer += accounts[i][j];
            }
            if (totalWealthPerCustomer > maxWealth) {
                maxWealth = totalWealthPerCustomer;
            }
        }
        return maxWealth;
    }
}
