// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells 
// need to be validated according to the following rules:
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:
// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                rows[i][j] = false;
                cols[i][j] = false;
                boxes[i][j] = false;
            }
        }
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    if (!rows[i][board[i][j] - '1'] && !cols[j][board[i][j] - '1'] 
                    && !boxes[(i/3) * 3 + j/3][board[i][j] - '1']) {
                        rows[i][board[i][j] - '1'] = true;
                        cols[j][board[i][j] - '1'] = true;
                        boxes[(i/3) * 3 + j/3][board[i][j] - '1'] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void Run() {
        char[][] board = new char[][] { 
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'} 
        };
        ValidSudoku s = new ValidSudoku();
        System.out.println(s.isValidSudoku(board));

        board[0][0] = '8';
        System.out.println(s.isValidSudoku(board));
    }
}
