// Backtracking 
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList();
        dfs(s,0, output, new ArrayList<String>());
        return output;
    }
    
    private void dfs(String s,int start, List<List<String>> output, List<String> current){
        if(start >= s.length()){
            output.add(new ArrayList<String>(current));
        }
        for(int end=start; end< s.length();end++){
            if(isAPalindrome(s, start, end)){
                current.add(s.substring(start,end+1));
                dfs(s, end+1, output, current);
                current.remove(current.size()-1);
            }
        }
    }
    
    private boolean isAPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}

// DP + Backtracking
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        dfs(s, 0, output, new ArrayList<String>(), dp);
        return output;
    }
    
    private void dfs(String s,int start, List<List<String>> output, List<String> current, boolean [][] dp){
        if(start >= s.length()){
            output.add(new ArrayList<String>(current));
            return;
        }
        for(int end=start; end< s.length();end++){
            if(s.charAt(start) == s.charAt(end) && (end-start <=2 || dp[start+1][end-1])){
                dp[start][end] = true;
                current.add(s.substring(start,end+1));
                dfs(s, end+1, output, current, dp);
                current.remove(current.size()-1);
            }
        }
    }
}