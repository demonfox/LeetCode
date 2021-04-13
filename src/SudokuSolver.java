
// Write a program to solve a Sudoku puzzle by filling the empty cells.
// A sudoku solution must satisfy all of the following rules:
// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.

import java.util.ArrayList;
import java.util.HashSet;

public class SudokuSolver {
  private ArrayList<HashSet<Character>> rows;
  private ArrayList<HashSet<Character>> cols;
  private ArrayList<HashSet<Character>> boxes;

  public void solveSudoku(char[][] board) {
    rows = new ArrayList<HashSet<Character>>();
    cols = new ArrayList<HashSet<Character>>();
    boxes = new ArrayList<HashSet<Character>>();
    for (int i=0; i<board.length; i++) {
      rows.add(new HashSet<Character>());
      cols.add(new HashSet<Character>());
      boxes.add(new HashSet<Character>());
    }
    // track all the pre-filled grids
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.') {
          rows.get(i).add(board[i][j]);
          cols.get(j).add(board[i][j]);
          boxes.get((i / 3) * 3 + j / 3).add(board[i][j]);
        }
      }
    }
    solve(board);
  }

  private boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {
            if (isValidSudoku(board, i, j, c)) {
              board[i][j] = c;
              rows.get(i).add(c);
              cols.get(j).add(c);
              boxes.get((i / 3) * 3 + j / 3).add(c);
              if (solve(board))
                return true;
              board[i][j] = '.';
              rows.get(i).remove(c);
              cols.get(j).remove(c);
              boxes.get((i / 3) * 3 + j / 3).remove(c);
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValidSudoku(char[][] board, int row, int col, char c) {
    return !rows.get(row).contains(c) 
          && !cols.get(col).contains(c) 
          && !boxes.get((row / 3) * 3 + col / 3).contains(c);
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
    SudokuSolver s = new SudokuSolver();
    s.solveSudoku(board);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
