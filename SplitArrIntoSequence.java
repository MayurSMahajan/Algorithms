import java.util.ArrayList;

//LeetCode : https://leetcode.com/problems/split-array-into-consecutive-subsequences/
public class SplitArrIntoSequence {
    public static void main(String[] args) {
        SplitArr sr = new SplitArr();
        int[] nums = { 1, 2, 3, 4, 4, 5, 6 };
        System.out.println(sr.isPossible(nums));
    }
}

/**
 * SplitArr
 */
class SplitArr {

    public boolean isPossible(int[] nums) {
        if (nums.length < 6) {
            return false;
        }

        ArrayList<Integer> subArray1 = new ArrayList<>();
        ArrayList<Integer> subArray2 = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] == nums[i]+1 && subArray1.size() < 3){
                if(!subArray1.contains(nums[i])){
                    subArray1.add(nums[i]);
                }
            }
            else{
                if(subArray2.size() < 3 && !subArray2.contains(nums[i])){
                    subArray2.add(nums[i]);
                }
            }
        }

        System.out.println(subArray1);
        System.out.println(subArray2);

        if(isSubArrNotOk(subArray1) && isSubArrNotOk(subArray2)){
            return false;
        }

        boolean isNumsEmpty = (nums.length -  (subArray1.size() + subArray2.size()) ) > 0;
        if (subArray1.size() == 3 && subArray2.size() == 3) {
            if(isNumsEmpty){
                return true;
            }
            //check if the first of the remaining element is larger then subarr2's last element
            if(subArray2.get(subArray2.size() - 1) + 1 == nums[6]){
                return true;
            }
        }

        System.out.println("Final return");
        return false;
    }

    private boolean isSubArrNotOk(ArrayList<Integer> subArr){
        for (int i = 0; i < subArr.size() -1; i++) {
            if(subArr.get(i) + 1 != subArr.get(i+1)){
                return true;
            }
        }
        return false;
    }

}

/*TestCases :
[1,2,3,3,4,5,5,5,6,6,6,7,7,7,8,8,8,8,8,9,9,9,10,10,10,10]
[1,2,3,5,6,7]
[5,6,7,8,9,10,10]
*/