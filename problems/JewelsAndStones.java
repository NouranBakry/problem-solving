/**
 * Solution: attempt idea: loop on jewels characters since they are unique,
 * count whenever a jewel is found among the stones evaluation: O(pq) p length
 * of Jewels and q length of stones
 * 
 */

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char j : jewels.toCharArray()) {
            for (char s : stones.toCharArray()) {
                if (s == j) {
                    count++;
                }
            }
        }
        return count;
    }
}