//  121. https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStockI {
    public static void main(String[] args) {
        BTBSSI b = new BTBSSI();
        int[] prices = {5,4,2,7,8,9};
        System.out.println(b.maxProfit(prices));
    }
}

class BTBSSI {
    public int maxProfit(int[] prices) {
        
        int min_price = prices[0];
        int max_price = prices[0];
        int max_profit = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(min_price > prices[i]){
                min_price = prices[i];
                max_price = prices[i];
            }
            else if(max_price < prices[i]){
                max_price = prices[i];
            }
            max_profit = Math.max(max_price - min_price,max_profit);
            
        }
        return max_profit;
    }
}

//Optimized: Check if the current price is the lowest we have seen, in that don't compare max_profit at that stage.
//  If not, check if by subtracting the current price from the lowest ever price we can find the greatest profit ever.
// Note finding the lowest price and calculating max profit are mutually exclusive.
/*
class Solution {
    public int maxProfit(int[] prices) {
        int lowest_price = prices[0], max_profit= 0;
        for(int i=1; i< prices.length; i++){
            if(prices[i] < lowest_price){
                lowest_price = prices[i];
                continue;
            }
            max_profit = Math.max(max_profit, (prices[i] - lowest_price));
        }
        return max_profit;
    }   
}

*/
