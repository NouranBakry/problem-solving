

// I wrote code using a map to store each character and the index as a key then using a string builder to construct a string from the map
// that solution is not the fastest out there
// we could use the solution below



// another solution 
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }
        return String.valueOf(arr);
    }
}