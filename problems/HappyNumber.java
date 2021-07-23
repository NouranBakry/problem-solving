class Solution {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        if(n == 1){
            return true;
        }
        while (record.add(n)){
            int sum = 0;
            while(n > 0){
                int num = n % 10;
                sum += (num*num);
                n = n/10;
            }
            if(sum == 1){
                return true;
            } else{
                n = sum;
            }
        }
        return false;
    }
}