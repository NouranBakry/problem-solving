class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        int prev = 4000;
        int curr = 0;
        int total = 0;
        for(char c: s.toCharArray()){
            if(values.get(c) > prev){
                curr = values.get(c) - prev;
                total = total- prev;
                total += curr;
                curr = total;
            }
            else {
                curr += values.get(c);
                total = curr;
            }
            prev = values.get(c);
        }
        return total;
    }
}