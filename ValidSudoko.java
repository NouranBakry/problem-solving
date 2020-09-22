import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        HashSet<String> boxSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] != '.') {
                    if (!rowSet.add(board[i][j])){
                        return false;
                    }

                    if (!boxSet.add(i / 3 + "-" + j / 3 + "-" + board[i][j])){
                        return false;
                    }
                }

                if (board[j][i] != '.') {
                    if (!colSet.add(board[j][i])){
                        return false;
                    }
                }
            }
            rowSet.clear();
            colSet.clear();
        }
        return true;
    }
}