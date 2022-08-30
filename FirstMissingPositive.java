import java.util.*;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FMP fmp = new FMP();
        // int[] arr = { 3, 4, -1, 1, 0 };
        // int[] arr = { 1,2,0 };
        int[] arr = { 1,1 };
        
        System.out.println(fmp.firstMissingPositive(arr));
    }
}

/*
 * https://leetcode.com/problems/first-missing-positive/
 * LeetCode - Hard
 */
class FMP {

    public int firstMissingPositive(int[] nums) {
        

        // first of all, we don't care about non-positive numbers or zero, so lets
        // remove them
        List<Integer> posList = new ArrayList<Integer>(nums.length);
        for (int num : nums) {
            if (num > 0 && !posList.contains(num)) {
                posList.add(num);
            }
        }

        // apply sort on posList
        Collections.sort(posList);

        //now we know that the first element is the smallest element in the posList
        //now we will check what is smaller then it. If none found return one number larger
        int ans = 1;
        int index = 0;

        while (index < posList.size()) {
            if(ans < posList.get(index)){
                return ans;
            }
            else{
                ans++;
                index++;
            }
        }

        return ans;
    }

}
