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

  public int totalNQueens2(int n) {
    totalSol = 0;
    // using 3 32-bit Integer to keep track of positions of every Queen
    helper2(0, 0, 0, 0, n);
    return totalSol;
  }

  private void helper2(int cols, int pies, int nas, int row, int n) {
    if (row >= n) {
      totalSol++;
      return;
    }

    int availablePos = (~(cols | pies | nas)) & ((1<<n) - 1);
    while (availablePos != 0) {
      // get the next available pos
      int pos = availablePos & -availablePos;
      helper2(cols | pos, ((pies | pos) << 1), ((nas | pos) >> 1), row+1, n);
      // clear the bit since we have checked this pos
      availablePos &= (availablePos-1);
    }
  }

  public static void Run() {
    NQueensII n = new NQueensII();
    System.out.println(n.totalNQueens(4));
    System.out.println(n.totalNQueens(1));
    System.out.println(n.totalNQueens(8));
    System.out.println(n.totalNQueens2(4));
    System.out.println(n.totalNQueens2(1));
    System.out.println(n.totalNQueens(8));
  }
}
