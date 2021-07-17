// time O(n), space O(1)
// other approaches is to use string concatenation or hashing -> same complexity 

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>();
        for(int i=1; i<n+1; i++){
            if(i % 3==0 && i % 5==0){
                output.add("FizzBuzz");
            } else if(i % 3==0){
                output.add("Fizz");
            } else if( i % 5==0){
                output.add("Buzz");
            } else {
                output.add(String.valueOf(i));
            }
        }
        return output;
    }
}