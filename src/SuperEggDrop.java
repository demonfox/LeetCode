import java.util.Arrays;

// You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
// You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor 
// higher than f will break, and any egg dropped at or below floor f will not break.
// Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). 
// If the egg breaks, you can no longer use it. However, if the egg does not break, you may 
// reuse it in future moves.
// Return the minimum number of moves that you need to determine with certainty what the value of f is.

public class SuperEggDrop {
  private int memory[][];
  public int superEggDrop(int k, int n) {
    memory = new int[k+1][n+1];
    for (int[] row : memory) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    return dp(k, n);
  }

  private int dp(int k, int n) {
    if (k == 0) return 0;
    if (k == 1) return n;
    if (n <= 1) return n;
    if (memory[k][n] != Integer.MAX_VALUE)
      return memory[k][n];
    int l = 1;
    int r = n;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (dp(k-1, m-1) >= dp(k, n-m))
        r = m-1;
      else
        l = m + 1;
    }
    memory[k][n] = 1 + Math.max(dp(k-1, l-1), dp(k, n-l));
    return memory[k][n];
  }

  public static void Run() {
    SuperEggDrop s = new SuperEggDrop();
    System.out.println(s.superEggDrop(1, 2));
    System.out.println(s.superEggDrop(2, 6));
    System.out.println(s.superEggDrop(3, 14));
  }
}
