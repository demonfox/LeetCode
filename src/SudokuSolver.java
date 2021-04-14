
// Write a program to solve a Sudoku puzzle by filling the empty cells.
// A sudoku solution must satisfy all of the following rules:
// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import javafx.util.Pair;

public class SudokuSolver {
  private ArrayList<HashSet<Character>> rows;
  private ArrayList<HashSet<Character>> cols;
  private ArrayList<HashSet<Character>> boxes;
  private PriorityQueue<Pair<Integer, HashSet<Character>>> candidates;

  // a solver to reduce the search space by pre-processing the grids to narrow
  // down their possible choices
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

    candidates = new PriorityQueue<Pair<Integer, HashSet<Character>>>(new Comparator<>() {
      @Override
      public int compare(Pair<Integer, HashSet<Character>> p1, Pair<Integer, HashSet<Character>> p2) {
          return Integer.compare(p1.getValue().size(), p2.getValue().size());
      }
    });

    // for every empty grid, fill out all possible candidate numbers for it
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          HashSet<Character> gridChars = new HashSet<>();
          gridChars.add('1'); gridChars.add('2'); gridChars.add('3');
          gridChars.add('4'); gridChars.add('5'); gridChars.add('6');
          gridChars.add('7'); gridChars.add('8'); gridChars.add('9');   
          gridChars.removeAll(rows.get(i));
          gridChars.removeAll(cols.get(j));
          gridChars.removeAll(boxes.get((i / 3) * 3 + j / 3));
          candidates.add(new Pair<Integer, HashSet<Character>>(i * board[0].length + j, gridChars));
        }
      }
    }

    solve(board);
  }

  private boolean solve(char[][] board) {
    if (candidates.isEmpty())
      return true;

    Pair<Integer, HashSet<Character>> grid = candidates.poll();
    int row = grid.getKey() / board[0].length;
    int col = grid.getKey() % board[0].length;
    HashSet<Character> gridChars = grid.getValue();
    for (char c : gridChars) {
      if (isValidSudoku(board, row, col, c)) {
        board[row][col] = c;
        rows.get(row).add(c);
        cols.get(col).add(c);
        boxes.get((row / 3) * 3 + col / 3).add(c);
        if (solve(board))
          return true;
        board[row][col] = '.';
        rows.get(row).remove(c);
        cols.get(col).remove(c);
        boxes.get((row / 3) * 3 + col / 3).remove(c);
      }
    }
    // we did not find a proper solution in this recursion, need to put this grid back onto the 
    // queue so that when we try a different value for the previous grid, we will revisit this grid
    // when we come back again
    candidates.add(grid);
    return false;
  }

  public void solveSudoku2(char[][] board) {
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
    solve2(board);
  }

  private boolean solve2(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {
            if (isValidSudoku(board, i, j, c)) {
              board[i][j] = c;
              rows.get(i).add(c);
              cols.get(j).add(c);
              boxes.get((i / 3) * 3 + j / 3).add(c);
              if (solve2(board))
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
    s.solveSudoku2(board);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
