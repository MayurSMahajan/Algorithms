//Time Limit Exceeded Solution
//Leetcode : https://leetcode.com/problems/stock-price-fluctuation/

import java.util.HashMap;

/*
 * ["StockPrice","update","update","current","maximum","update","maximum","update","minimum"]
    [[],[1,10],[2,5],[],[],[1,3],[],[4,2],[]]
 */

public class StockPriceFluctuation {
    public static void main(String[] args) {
        StockPrice obj = new StockPrice();
        obj.update(1, 10);
        obj.update(2, 5);
        System.out.println("Current Price is : " + obj.current());
        System.out.println("maximum Price is : " + obj.maximum());

        obj.update(1, 3);
        System.out.println("maximum Price is : " + obj.maximum());

        obj.update(4, 2);
        System.out.println("minimum Price is : " + obj.minimum());
    }
}

class StockPrice {

    private HashMap<Integer, Integer> data;

    public StockPrice() {
        data = new HashMap<Integer, Integer>();
    }

    public void update(int timestamp, int price) {
        data.put(timestamp, price);
    }

    public int current() {
        int latest_timestamp = 1;
        for (HashMap.Entry<Integer, Integer> el : data.entrySet()) {
            latest_timestamp = Math.max(el.getKey(), latest_timestamp);
        }
        return data.get(latest_timestamp);
    }

    public int maximum() {
        int max_stock_price = 1;
        for (HashMap.Entry<Integer, Integer> el : data.entrySet()) {
            max_stock_price = Math.max(el.getValue(), max_stock_price);
        }

        return max_stock_price;
    }

    public int minimum() {
        int min_stock_price = 1000000;
        for (HashMap.Entry<Integer, Integer> el : data.entrySet()) {
            min_stock_price = Math.min(el.getValue(), min_stock_price);
        }

        return min_stock_price;
    }
}