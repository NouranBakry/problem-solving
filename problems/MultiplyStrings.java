/***
 * Required 
 * String Builder
 * Should support large numbers 
 * cant use int or long data types
 */

class Solution {
    public String multiply(String num1, String num2){

        int first = 0;
        int second = 0;
        for(char c: num1.toCharArray()){
            first = first*10 + c -'0';
        }
        for(char c: num2.toCharArray()){
            second = second*10 + c-'0';
        }
        int product = first * second;
        return String.valueOf(product);
    }
}
