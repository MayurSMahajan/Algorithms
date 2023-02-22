/*
Write a function 'howSum(target, nums)' that takes in a  target and an array of numbers as arguments. 
The function should return an array containing any combination of elements that add up to exactly the target. If there is no combination that adds up to exactly the target, then return null.
If there are multiple combinations possible, you may return any single one.
Note you can reuse the elements in number multiple times.
*/


import java.util.List;
import java.util.ArrayList;

public class HowSum
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		CanSum c = new CanSum();
		int target = 5000;
		int[] options = {7,14, 5};
		int[] memo = new int[target+1];
		for(int i=0; i<= target; i++){
		    memo[i] = -1;
		}
		List<Integer> possibleRoute = new ArrayList<Integer>();
		boolean isPossible = c.canSum(target, options, memo, possibleRoute);
		if(isPossible){
		    System.out.println(possibleRoute);
		}
		else{
		    System.out.println("No possibleRoute found");
		}
	}
}

class CanSum{
    public boolean canSum(int target, int[] nums, int[] memo, List<Integer> possibleRoute){
        if(target == 0) return true;
        if(target < 0) return false;
        
        if(memo[target] == 1) return true;
        if(memo[target] == 0) return false;
        
        for(int el : nums){
            int remainder = target - el;
            if(canSum(remainder, nums, memo, possibleRoute) == true) {
                possibleRoute.add(el);
                memo[target] = 1;
                return true;
            }
        }
        
        memo[target] = 0;
        return false;
    }
}
