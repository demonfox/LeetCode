// -----------  Problem Synopsis  ----------- //
// Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (ie, buy one and sell one 
// share of the stock), design an algorithm to find the maximum profit.
// ------------------------------------------ //

public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    if (prices.length <= 1)
      return 0;

    int maxprofit = 0;
    int low = prices[0];

    for (int i = 1; i < prices.length; i++) {
      maxprofit = Math.max(prices[i] - low, maxprofit);
      low = Math.min(prices[i], low);
    }

    return maxprofit;
  }

  // using dynamic programming
  public int maxProfit2(int[] prices) {
    int result = 0;
    int[][] profits = new int[prices.length][3];
    profits[0][0] = 0; // profit value for "No Stock"
    profits[0][1] = -prices[0]; //profit value for "Buy"
    profits[0][2] = 0; // profit value for "Sell", but we cannot really sell, so start with 0
    for (int i=1; i<prices.length; i++) {
      profits[i][0] = profits[i-1][0];
      profits[i][1] = Math.max(profits[i-1][1], profits[i-1][0]-prices[i]);
      profits[i][2] = profits[i-1][1]+prices[i];
      result = Math.max(Math.max(Math.max(profits[i][0], profits[i][1]), profits[i][2]), result);
    }
    return result;
  }

  public static void Run() {

  }
}
