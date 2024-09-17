// Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of 
// unique values from 1 to n.

public class UniqueBinarySearchTrees {
  public int numTrees(int n) {
    // the function numTrees(n) or f(n) is actually a fibonacci-like sequence where:
    // f(n) = (f(n-1) * f(0)) + (f(n-2) * f(1)) + ... + (f(0) * f(n-1)) 
    // f(0) = 1, f(1) = 1
    // f(2) = f(1) * f(0) + f(0) * f(1) = 2
    // f(3) = f(2) * f(0) + f(1) * f(1) + f(0) * f(2) = 5

    if (n == 1) return 1;
    if (n == 2) return 2;

    int[] fn = new int[n+1];
    fn[0] = 1;
    fn[1] = 1;
    for (int i=2; i<=n; i++) {
      int sum = 0;
      for (int j=0; j<i; j++) {
        sum += fn[j] * fn[i-j-1];
      }
      fn[i] = sum;
    }
    return fn[n];
  }

  public static void Run() {
    UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
    System.out.println(solution.numTrees(1));
    System.out.println(solution.numTrees(2));
    System.out.println(solution.numTrees(3));
    System.out.println(solution.numTrees(4));
    System.out.println(solution.numTrees(5));
    System.out.println(solution.numTrees(6));
    System.out.println(solution.numTrees(7));
    System.out.println(solution.numTrees(8));
    System.out.println(solution.numTrees(9));
    System.out.println(solution.numTrees(10));
    System.out.println(solution.numTrees(11));
    System.out.println(solution.numTrees(12));
    System.out.println(solution.numTrees(13));
    System.out.println(solution.numTrees(14));
    System.out.println(solution.numTrees(15));
  }
}
