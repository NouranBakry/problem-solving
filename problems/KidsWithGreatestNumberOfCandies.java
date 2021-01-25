/**
 * Solution: What do we need to do? 1. find the maximum number of candies among
 * the kids 2. Check every kid's possibility to have this maximum candies
 */

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }
        for (int j = 0; j < candies.length; j++) {
            if (candies[j] >= maxCandies || candies[j] + extraCandies >= maxCandies) {
                result.add(true);
            } else
                result.add(false);
        }
        return result;
    }
}
