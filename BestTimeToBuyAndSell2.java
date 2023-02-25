//Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//Hint: Imagine a graph that represents all stock prices. The answer of this question can be found be adding all the increments in the graph, or all the positive slopes.

class BestTimeToBuyAndSell2 {
    public int maxProfit(int[] prices) {
        int slope = 0;
        for(int i=1; i< prices.length; i++){
            int diff = prices[i] - prices[i-1];
            if(diff > 0){
                slope += diff;
            }
        }
        return slope;
    }
}
