// O(n), space O(26)-> O(1)
// greedy algorithm 
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> output = new ArrayList<>();
        int[] map = new int[26];
        for(int i=0; i<s.length();i++){
            map[s.charAt(i)-'a'] = i;
        }
        int last = 0;
        int start = 0;
        for(int i=0; i< s.length();i++){
            last = Math.max(last, map[s.charAt(i)-'a']);
            if(i == last){
                output.add(i - start+1);
                start = i+1;
            }
        }
        return output;
    }    
}