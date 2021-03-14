// You are given coins of different denominations and a total amount of money amount. 
// Write a function to compute the fewest number of coins that you need to make up that amount. 
// If that amount of money cannot be made up by any combination of the coins, return -1.
// You may assume that you have an infinite number of each kind of coin.

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int[] coinRequiredForAmount = new int[amount+1];
    coinRequiredForAmount[0] = 0; // coin required for 0 amount is 0
    for (int amt=1; amt<=amount; amt++) {
      coinRequiredForAmount[amt] = Integer.MAX_VALUE;
      for (int i=0; i<coins.length; i++) {
        if (coins[i] <= amt) {
          if (coinRequiredForAmount[amt-coins[i]] != Integer.MAX_VALUE) {
            coinRequiredForAmount[amt] = Math.min(coinRequiredForAmount[amt-coins[i]]+1, coinRequiredForAmount[amt]);
          }
        }
      }
    }

    return (coinRequiredForAmount[amount] == Integer.MAX_VALUE) ? -1 : coinRequiredForAmount[amount];
  }

  public static void Run() {
    CoinChange c = new CoinChange();
    System.out.println(c.coinChange(new int[]{1,2,5}, 11));
    System.out.println(c.coinChange(new int[]{1}, 0));
    System.out.println(c.coinChange(new int[]{2}, 3));
    System.out.println(c.coinChange(new int[]{1}, 1));
    System.out.println(c.coinChange(new int[]{1}, 2));
  }
}
