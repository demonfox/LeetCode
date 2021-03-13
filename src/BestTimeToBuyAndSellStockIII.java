// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete at most two transactions.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the 
// stock before you buy again).

public class BestTimeToBuyAndSellStockIII {
  public int maxProfit(int[] prices) {
    if (prices.length < 2)
      return 0;
    // these two arrays record the best transactional profit you can find
    // to the left of prices[i] and to the right of prices[i]; or you can
    // say: find the best transactional price till day i, and the best
    // transactional profit from day i onwards
    int[] profits1 = new int[prices.length];
    int[] profits2 = new int[prices.length];
    int low = prices[0];
    int high = prices[prices.length-1];
    int maxprofit = 0;

    for (int i=0; i<prices.length; i++) {
      profits1[i] = Math.max(maxprofit, prices[i] - low);
      maxprofit = Math.max(maxprofit, profits1[i]);
      low = Math.min(low, prices[i]);
    }

    maxprofit = 0;

    for (int i=prices.length -1; i>=0; i--) {
      profits2[i] = Math.max(maxprofit, high - prices[i]);
      maxprofit = Math.max(maxprofit, profits2[i]);
      high = Math.max(high, prices[i]);
    }

    for (int i=0; i<prices.length; i++) {
      maxprofit = Math.max(maxprofit, profits1[i] + profits2[i]);
    }

    return maxprofit;
  }

  public static void Run() {
    BestTimeToBuyAndSellStockIII s = new BestTimeToBuyAndSellStockIII();
    // System.out.println(s.maxProfit(new int[] {3,3,5,0,0,3,1,4}));
    // System.out.println(s.maxProfit(new int[] {1,2,3,4,5}));
    // System.out.println(s.maxProfit(new int[] {7,6,4,3,1}));
    // System.out.println(s.maxProfit(new int[] {1}));
    System.out.println(s.maxProfit(new int[] {5,7,2,4,9}));
    System.out.println(s.maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0}));
  }
}
