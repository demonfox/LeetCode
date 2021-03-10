// Given an m x n gird of characters board and a string word, 
// return true if word exists in the grid.
// The word can be constructed from letters of sequentially 
// adjacent cells, where adjacent cells are horizontally or 
// vertically neighboring. The same letter cell may not be used more than once.
// Note: There will be some test cases with a board or a word larger than 
// constraints to test if your solution is using pruning.

import java.util.Map;
import java.util.HashMap;

public class WordSearch {
  public boolean exist(char[][] board, String word) {
    Map<Character, Integer> occurrence = new HashMap<Character, Integer>();
    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++) {
        int count = occurrence.getOrDefault(board[i][j], 0);
        occurrence.put(board[i][j], count+1);
      }
    }

    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++) {
        int count = occurrence.get(board[i][j]);
        occurrence.put(board[i][j], count-1);
      }
    }

    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++) {
        if (occurrence.get(board[i][j]) != 0)
          return false;
      }
    }

    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if(dfs(board, i, j, word, 0))
            return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, int i, int j, String word, int wIdx) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
      || board[i][j] == '#' || board[i][j] != word.charAt(wIdx)) {
        return false;
    }

    if (wIdx == word.length() - 1)
      return true;

    char bt = board[i][j];
    board[i][j] = '#';

    if (dfs(board, i-1, j, word, wIdx+1) 
      || dfs(board, i+1, j, word, wIdx+1) 
      || dfs(board, i, j-1, word, wIdx+1) 
      || dfs(board, i, j+1, word, wIdx+1)) {
        return true;
    }

    board[i][j] = bt;
    return false;
  }

  public static void Run() {
    WordSearch s = new WordSearch();
    char[][] board = new char[][] { {'A','B','C','E'},{'X','F','C','S'},{'A','D','E','E'} };
    System.out.println(s.exist(board, "ABCCED"));
    board = new char[][] { {'A','B','C','E'},{'X','F','C','S'},{'A','D','E','E'} };
    System.out.println(s.exist(board, "SEE"));
    board = new char[][] { {'A','B','C','E'},{'X','F','C','S'},{'A','D','E','E'} };
    System.out.println(s.exist(board, "ABCB"));
  }
}
