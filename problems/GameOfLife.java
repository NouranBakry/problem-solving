/** 1st solution O(mn) time and O(mn) space */
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // directions
        int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        int[][] nextState = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    // valid coordinates
                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 1) {
                        liveCount++;
                    }
                }
                if (board[i][j] == 0 && liveCount == 3) {
                    nextState[i][j] = 1;
                }
                if (board[i][j] == 1 && (liveCount == 2 || liveCount == 3)) {
                    nextState[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nextState[i][j];
            }
        }
    }
}

/**
 * O(mn) time and O(1) space
 */

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // directions
        int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    // valid coordinates
                    if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == -1)) {
                        liveCount++;
                    }
                }
                if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = -1;
                }

                if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else if (board[i][j] < 0) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
