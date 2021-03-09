// The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
// such that no two queens attack each other.
// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

import java.util.HashSet;
import java.util.Set;

public class NQueensII {
  private int totalSol;
  public int totalNQueens(int n) {
    totalSol = 0;
    Set<Integer> cols = new HashSet<Integer>();
    Set<Integer> pies = new HashSet<Integer>();
    Set<Integer> nas = new HashSet<Integer>();
    helper(cols, pies, nas, n);
    return totalSol;
  }

  private void helper(Set<Integer> cols, Set<Integer> pies, Set<Integer> nas, int n) {
    if (cols.size() >= n) {
      totalSol++;
    }

    int currRow = cols.size();
    for (int j=0; j<n; j++) {
      if (cols.contains(j) || pies.contains(currRow + j) || nas.contains(currRow - j))
        continue;
      cols.add(j);
      pies.add(currRow + j);
      nas.add(currRow - j);
      helper(cols, pies, nas, n);
      cols.remove(j);
      pies.remove(currRow + j);
      nas.remove(currRow - j);
    }
  }

  public static void Run() {
    NQueensII n = new NQueensII();
    System.out.println(n.totalNQueens(4));
    System.out.println(n.totalNQueens(1));
  }
}
