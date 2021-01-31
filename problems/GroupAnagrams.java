/**
 * evaluation: O(nklogk) where n is the length of strs (array) and k is the
 * maximum length of a string (klogk) for sorting each string Space complexity
 * is the size of output list => O(nk)
 * 
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        if (strs.length == 0)
            return new ArrayList<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            output.add(map.get(key));
        }
        return output;
    }
}
