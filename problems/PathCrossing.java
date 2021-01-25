class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        set.add(x + "$" + y);
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y += 1;
            }
            if (c == 'S') {
                y -= 1;
            }
            if (c == 'E') {
                x += 1;
            }
            if (c == 'W') {
                x -= 1;
            }
            String key = x + "$" + y;
            if (!set.add(key)) {
                return true;
            }
        }
        return false;
    }
}