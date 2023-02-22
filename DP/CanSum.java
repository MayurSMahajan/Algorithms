/*You are given an array of non-negative numbers and a value 'sum'. 
  You have to find out whether a subset of the given array is present whose sum is equal to the given value 
  You can reuse any elements in the array.
  Eg: target = 7, nums = {2,3,4,7} => true
      target = 300, nums = {7,14} => false
*/

public class CanSum
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		CanSumBase c = new CanSumBase();
		int target = 300;
		int[] options = {7,14};
		int[] memo = new int[target+1];
		for(int i=0; i<= target; i++){
		    memo[i] = -1;
		}
		System.out.println(c.canSum(target, options, memo));
	}
}

class CanSumBase{
    public boolean canSum(int target, int[] nums, int[] memo){
        if(target == 0) return true;
        if(target < 0) return false;
        
        if(memo[target] == 1) return true;
        if(memo[target] == 0) return false;
        
        for(int el : nums){
            int remainder = target - el;
            if(canSum(remainder, nums, memo) == true) {
                memo[target] = 1;
                return true;
            }
        }
        
        memo[target] = 0;
        return false;
    }
}

