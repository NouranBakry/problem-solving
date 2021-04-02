/**
 * Time Complexity
 * O(rows * columns * log * length of diagonal)
 * longest diagonal is min(m,n)
 */

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i - j).add(mat[i][j]);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        return mat;
    }
}