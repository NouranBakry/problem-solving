/** time and space complexity O(4^n/n*sqrt(n)) */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allParenthesis = new ArrayList<>();
        backtrack(allParenthesis,new StringBuilder(),0,0,n);
        return allParenthesis;
    }
    private void backtrack(List<String> allParenthesis, StringBuilder curr, int open, int close, int max){
        if(curr.length() == max * 2){
            allParenthesis.add(curr.toString());
            return;
        }
        if (open < max){
            curr.append("(");
            backtrack(allParenthesis,curr,open+1,close,max);
            curr.deleteCharAt(curr.length()-1);
        }
        if (close < open){
            curr.append(")");
            backtrack(allParenthesis,curr,open,close+1,max);
            curr.deleteCharAt(curr.length()-1);
        } 
    }
}