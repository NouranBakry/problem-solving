class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && backtrack(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int row, int col, int first, String word, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] == true
                || board[row][col] != word.charAt(first)) {
            return false;
        }
        if (first == word.length() - 1) {
            return true;
        }
        visited[row][col] = true;
        if (backtrack(board, row + 1, col, first + 1, word, visited)
                || backtrack(board, row, col + 1, first + 1, word, visited)
                || backtrack(board, row - 1, col, first + 1, word, visited)
                || backtrack(board, row, col - 1, first + 1, word, visited)) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }
}