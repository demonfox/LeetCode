// According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton 
// devised by the British mathematician John Horton Conway in 1970."
// The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented 
// by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, 
// vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
// Any live cell with fewer than two live neighbors dies as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// The next state is created by applying the above rules simultaneously to every cell in the current state, 
// where births and deaths occur simultaneously. 
// Given the current state of the m x n grid board, return the next state.

public class GameOfLife {
  // The idea is to encode the current state and the next state using a unique value such that
  // 1) we can recognize the grid's current state and the next state simultaneously
  // 2) the values for combinations of <current_state, next_state> need to be mutually exclusive (or unique)
  // We then do a 2-pass iteration through the whole board
  // Current Next Value
  // 0       0    100
  // 0       1    200
  // 1       0    101
  // 1       1    201
  // To get the current state, we do: board[i][j] % 10
  // To get the next state, we do: board[i][j] / 100 - 1 
  public void gameOfLife(int[][] board) {
    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++) {
        int count = countLiveNeighbors(board, i, j);
        if (count < 2 || count >3)
          board[i][j] = board[i][j] + 100;
        else if (count == 3) {
           board[i][j] = board[i][j] + 200;
        } else { // count == 2
          board[i][j] = board[i][j] + (board[i][j] + 1) * 100;
        }
      }
    }

    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++) {
        board[i][j] = board[i][j] / 100 -1;
      }
    }
  }

  private int countLiveNeighbors(int[][] board, int i, int j) {
    int count = 0;
    int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    for (int k=0; k<dx.length; k++) {
      int x = i + dx[k];
      int y = j + dy[k];
      if (x >= 0 && x < board.length && y >= 0 && y < board[0].length)
        count += (board[x][y] % 10);    
    }
    return count;
  }

  public static void Run() {
    GameOfLife g = new GameOfLife();
    int[][] board = new int[][] { {1, 1}, {1, 0}};
    g.gameOfLife(board);
    printBoard(board);

    board = new int[][]{
      {0,1,0},
      {0,0,1},
      {1,1,1},
      {0,0,0}
    };
    g.gameOfLife(board);
    printBoard(board);
  }

  private static void printBoard(int[][] board) {
    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
