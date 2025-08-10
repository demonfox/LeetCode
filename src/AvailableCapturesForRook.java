// You are given an 8 x 8 matrix representing a chessboard. There is exactly one white rook represented by 'R', some number of white 
// bishops 'B', and some number of black pawns 'p'. Empty squares are represented by '.'.
// A rook can move any number of squares horizontally or vertically (up, down, left, right) until it reaches another piece or the edge 
// of the board. A rook is attacking a pawn if it can move to the pawn's square in one move.
// Note: A rook cannot move through other pieces, such as bishops or pawns. This means a rook cannot attack a pawn if there is another 
// piece blocking the path.
// Return the number of pawns the white rook is attacking.

public class AvailableCapturesForRook {
  public int numRookCaptures(char[][] board) {
    int i=0, j=0;
    for (i=0; i<board.length; i++) {
      for (j=0; j<board[0].length; j++) {
        if (board[i][j] == 'R')
          break;
      }
      if (j < board[0].length)
        break;
    }

    int result = 0;
    for (int k=i-1; k>=0; k--) {
      if (board[k][j] == 'p') {
        result++;
        break;
      } else if (board[k][j] == 'B') {
        break;
      }
    }

    for (int k=i+1; k<8; k++) {
      if (board[k][j] == 'p') {
        result++;
        break;
      } else if (board[k][j] == 'B') {
        break;
      }
    }

    for (int k=j-1; k>=0; k--) {
      if (board[i][k] == 'p') {
        result++;
        break;
      } else if (board[i][k] == 'B') {
        break;
      }
    }

    for (int k=j+1; k<8; k++) {
      if (board[i][k] == 'p') {
        result++;
        break;
      } else if (board[i][k] == 'B') {
        break;
      }
    }

    return result;
  }

  public static void Run() {
    char[][] board = new char[][] {
      {'R', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', 'p', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', 'p', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.'}
    };
    
    AvailableCapturesForRook solution = new AvailableCapturesForRook();
    System.out.println(solution.numRookCaptures(board));

    board = new char[][] {
        { 'B', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', 'p', '.', '.', '.', '.' },
        { '.', '.', '.', 'p', '.', '.', '.', '.' },
        { '.', '.', '.', 'R', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.' }
    };
    System.out.println(solution.numRookCaptures(board));

    board = new char[][] {
        { '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
        { '.', 'p', 'p', 'B', 'p', 'p', '.', '.' },
        { '.', 'p', 'B', 'R', 'B', 'p', '.', '.' },
        { '.', 'p', 'p', 'B', 'p', 'p', '.', '.' },
        { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.' }
    };
    System.out.println(solution.numRookCaptures(board));
  }
}
