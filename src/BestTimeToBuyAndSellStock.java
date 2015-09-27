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
        
        int currMax = 0;
        int currBuy = prices[0];
        int currSell = currBuy;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currBuy) {
                currSell = currBuy = prices[i];
            } else if ((prices[i] > currSell) && (prices[i] - currBuy) > currMax) {
                    currMax = prices[i] - currBuy;
            }
        }
        
        return currMax;
    }
    
    public static void Run() {
        
    }
}
