// 2260. Minimum Consecutive Cards to Pick Up
// https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
// Faster than 75% and 55% memory efficient

public class MinConsecutiveCards{
	public static void main(String[] ar){
		int[] cards = {3,4,2,3,4,7};
		MinConsecutiveCardsToPickUp m = new MinConsecutiveCardsToPickUp();
		System.out.println(m.minimumCardPickup(cards));
	}
}

class MinConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        int minCardResult = Integer.MAX_VALUE;
        boolean isMatchNotFound = true;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i< cards.length; i++){
            if(map.containsKey(cards[i])){
                minCardResult = Math.min(minCardResult, (1 + i - map.get(cards[i])));  
                isMatchNotFound = false;
            }
            map.put(cards[i], i);
        }
        
        if(isMatchNotFound){
            return -1;
        }
        
        return minCardResult;
    }
}