import java.lang.Math;
class Solution {
    public int divide(int dividend, int divisor){
        int sign = 1;
        if((dividend > 0 && divisor <0) || (dividend <0 && divisor >0)){
            sign = 0 - sign;
        }
        if(Math.abs(dividend) == Math.abs(divisor)){
            return (sign<0)?-1:1;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int quotient = 0;
        while (Math.abs(dividend) >= Math.abs(divisor)){
            dividend = Math.abs(dividend) - Math.abs(divisor);
            if(quotient == Integer.MAX_VALUE-1){
                return (sign<0)? Integer.MIN_VALUE: Integer.MAX_VALUE;
             }
            ++quotient;
        }
        return (sign<0)? 0-quotient: quotient;
    }
}