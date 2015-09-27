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
    
    public static void Run() {
        
    }
}
