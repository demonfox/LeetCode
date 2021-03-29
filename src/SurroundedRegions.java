// Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
// Surrounded regions should not be on the border, which means that any 'O' on the border of the 
// board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' 
// on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected 
// horizontally or vertically.

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class SurroundedRegions {
  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    Queue<Pair<Integer, Integer>> q  = new LinkedList<>();
    
    for (int j=0; j<n; j++) {
      if (board[0][j] == 'O') {
        q.add(new Pair<Integer, Integer>(0, j));
      }
    }
    for (int j=0; j<n; j++) {
      if (board[m-1][j] == 'O') {
        q.add(new Pair<Integer, Integer>(m-1, j));
      }
    }
    for (int i=0; i<m; i++) {
      if (board[i][0] == 'O') {
        q.add(new Pair<Integer, Integer>(i, 0));
      }
    }
    for (int i=0; i<m; i++) {
      if (board[i][n-1] == 'O') {
        q.add(new Pair<Integer, Integer>(i, n-1));
      }
    }

    while (!q.isEmpty()) {
      Pair<Integer, Integer> grid = q.remove();
      int x = grid.getKey();
      int y = grid.getValue();
      if (board[x][y] == 'O') {
        board[x][y] = 'Z';
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        for (int k=0; k<4; k++) {
          int nx = x + dx[k];
          int ny = y + dy[k];
          if (nx >= 0 && nx <= m-1 && ny >= 0 && ny <= n-1 && board[nx][ny] == 'O')
            q.add(new Pair<Integer, Integer>(nx, ny));
        }
      }
    }

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (board[i][j] == 'O')
          board[i][j] = 'X';
        else if (board[i][j] == 'Z')
          board[i][j] = 'O';
      }
    }
  }

  public static void Run() {
    SurroundedRegions s = new SurroundedRegions();
    char[][] board = new char[][] {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
    //board = new char[][] {{'X'}};
    s.solve(board);
    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++)
        System.out.print(board[i][j]);
      System.out.println();
    }
  }
}
