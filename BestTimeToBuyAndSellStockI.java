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
