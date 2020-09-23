//[2,3,4,7,11], k = 5 Output: 9
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length;
        while(l<r){
            int m = l + (r - l) / 2;
            if(arr[m] -m -1 >= k){
                r = m;
            } else l = m+1;
        }
        return k+l;
    }
}