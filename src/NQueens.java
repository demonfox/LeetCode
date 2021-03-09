// The n-queens puzzle is the problem of placing n queens on an n x n 
// chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle.
// Each solution contains a distinct board configuration of the n-queens' 
// placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NQueens {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new LinkedList<List<String>>();
    LinkedList<String> board = new LinkedList<String>();
    Set<Integer> cols = new HashSet<Integer>();
    Set<Integer> pies = new HashSet<Integer>();
    Set<Integer> nas = new HashSet<Integer>();
    helper(cols, pies, nas, board, result, n);
    return result;
  }
  private void helper(Set<Integer> cols, Set<Integer> pies, Set<Integer> nas, LinkedList<String> board, List<List<String>> result, int n) {
    if (cols.size() >= n) {
      List<String> solution = new LinkedList<String>();
      solution.addAll(board);
      result.add(solution);
      return;
    }

    int currRow = cols.size();
    for (int j=0; j<n; j++) {
      if (cols.contains(j) || pies.contains(currRow + j) || nas.contains(currRow - j))
        continue;
      cols.add(j);
      pies.add(currRow + j);
      nas.add(currRow - j);
      board.addLast(".".repeat(j) + "Q" + ".".repeat(n-j-1));
      helper(cols, pies, nas, board, result, n);
      cols.remove(j);
      pies.remove(currRow + j);
      nas.remove(currRow - j);
      board.removeLast();
    }
  }

  public static void Run() {
    List<List<String>> result;
    NQueens n = new NQueens();
    result = n.solveNQueens(4);
    for (int i=0; i<result.size(); i++) {
      for (String s : result.get(i)) {
        System.out.println(s);
      }
      System.out.println();
    }
  }
}
