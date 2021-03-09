// -----------  Problem Synopsis  ----------- //
// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as 
// you like (ie, buy one and sell one share of the stock multiple times). However, you may not 
// engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
// ------------------------------------------ //

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        
        int currProfit = 0;
        int currBuy = prices[0];
        int currSell = currBuy;
        boolean sellingPointFound = false;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currBuy && sellingPointFound == false) {
                currSell = currBuy = prices[i];
            } else if (prices[i] > currSell) {
                currSell = prices[i];
                sellingPointFound = true;
            } else {
                // complete one transaction to lock in profit
                currProfit += (currSell - currBuy);
                currBuy = currSell = prices[i];
                sellingPointFound = false;
            }
        }
        
        // do the last transaction since the loop has ended as long as there is a profit
        if (currSell > currBuy)
            currProfit += currSell - currBuy;
        
        return currProfit;
    }
    
    public int maxProfit2(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
      int maxprofit = 0;
      for (int i=0; i<prices.length-1; i++) {
        if (prices[i] < prices[i+1]) {
          maxprofit += (prices[i+1] - prices[i]);
        }
      }
      return maxprofit;
    }
    public static void Run() {
        BestTimeToBuyAndSellStockII s = new BestTimeToBuyAndSellStockII();
        System.out.println(s.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(s.maxProfit2(new int[]{1,2,3,4,5}));
        System.out.println(s.maxProfit3(new int[]{1,2,3,4,5}));
    }
}
