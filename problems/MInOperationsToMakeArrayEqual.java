/**
 * arr[i] = (2 * i) + 1 so wow you don't really even need to build the array so
 * all you need is to make all the elements in the arr equal to the mean
 * example: n=3, [1, 3, 5],
 * should give us 2 ( num of operations used)
 * 1+1 -> 2, 5-1-> 4 first op
 * 2+1 -> 3, 4-1-> 3 second op
 * [3,3,3]
 * so 
 * 3-1 = 2; :)
 * start and end -> worst case O(n) and space O(1)
 */

class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        int numOfOperations = 0;
        // build the array using given formula
        int start = 1;
        int end = n;
        while (start < end) {
            numOfOperations += end - start;
            start += 1;
            end -= 1;
        }
        return numOfOperations;
    }
}