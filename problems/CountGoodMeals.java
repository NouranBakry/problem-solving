class Solution {
    public int countPairs(int[] deliciousness) {
        int MODULO_VAL = 1000000007;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deliciousness) {
            int sum = 1;
            for (int i = 0; i < 22; i++) {
                if (map.containsKey(sum - num)) {
                    count += map.get(sum - num);
                    count %= MODULO_VAL;
                }
                sum *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}