class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            char top = stack.pop();
            switch(c){
                case ')':
                    if(top != '(')
                        return false;
                    break;
                case '}':
                    if(top != '{')
                        return false;
                    break;
                case ']':
                    if(top != '[')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}