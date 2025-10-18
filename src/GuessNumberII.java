// We are playing the Guessing Game. The game will work as follows:
// I pick a number between 1 and n.
// You guess a number.
// If you guess the right number, you win the game.
// If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you will continue guessing.
// Every time you guess a wrong number x, you will pay x dollars. If you run out of money, you lose the game.
// Given a particular n, return the minimum amount of money you need to guarantee a win regardless of what number I pick.

public class GuessNumberII {
  // private HashMap<Integer, Integer> cache = new HashMap<>();
  int[][] moneyAmount;
  public int getMoneyAmount(int n) {
    if (n == 1) return 0;
    if (n == 2) return 1;

    moneyAmount = new int[n+1][n+1];
    int result = Integer.MAX_VALUE;
    int temp = Integer.MAX_VALUE;
    for (int i=2; i<=n-1; i++) {
      temp = i + memoization(i+1, n);
      if (temp >= result)
        continue;
      result = Math.min(result, Math.max(i + memoization(1, i-1), temp));
    }
    return result;
  }

  private int memoization(int start, int end) {
    // if (cache.containsKey(1000 * start + end))
    //   return cache.get(1000 * start + end);
    if (moneyAmount[start][end] != 0) return moneyAmount[start][end];
    if (start == end) {
      return 0;
    } else if (start == end -1) {
      return start;
    }
    int result = Integer.MAX_VALUE;
    int temp = Integer.MAX_VALUE;
    for (int i=start+1; i<=end-1; i++) {
      temp = i + memoization(i+1, end);
      if (temp >= result)
        continue;
      result = Math.min(result, Math.max(i + memoization(start, i-1), temp));

      //temp = Math.min(temp, Math.max(i + memoization(start, i-1), i + memoization(i+1, end)));
    }
    //cache.put(1000 * start + end, result);
    moneyAmount[start][end] = result;
    return result;
  }

  // ok, from the memoization method, we can see how the state transition function looks like for the DP method
  public int getMoneyAmount2(int n) {
    moneyAmount = new int[n+1][n+1];
    return dp(1,n);
  }

  private int dp(int start, int end) {
    if (start >= end) return 0;
    if (moneyAmount[start][end] != 0) return moneyAmount[start][end];
    int result = Integer.MAX_VALUE;
    for (int i=start; i<=end; i++) {
      result = Math.min(result, i + Math.max(dp(start, i-1), dp(i+1, end)));
    }
    moneyAmount[start][end] = result;
    return result;
  }

  public static void Run() {
    GuessNumberII g = new GuessNumberII();
    System.out.println(g.getMoneyAmount(10));
    System.out.println(g.getMoneyAmount(5));
    System.out.println(g.getMoneyAmount(3));
    System.out.println(g.getMoneyAmount(4));
  }
}
