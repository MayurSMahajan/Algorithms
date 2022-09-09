//This is not a leetcode problem. 
//Given an sorted array of numbers and a target value, 
//find the smallest value greater than or equal to target.
//Solution should be better than O(n).
//input 1 : [2,3,4,6,9,13,14,16] target = 10
//output : 13
//input 1 : [2,3,4,6,10,13,14,16] target = 10
//output : 10
public class CeilingOfNum {
    public static void main(String[] args) {
        Ceiling c = new Ceiling();
        // int[] nums = {2,4,7,8,9,10,13,14,15};
        // System.out.println(c.ceilingOfNum(nums, 11));
        char[] letters = {'c','f','j','m','o','p','r','s'};
        System.out.println(c.nextGreatestLetter(letters, 'q'));
    }
}

class Ceiling {
    public int ceilingOfNum(int[] nums, int target){
        
        //Implementing Binary Search.
        int best_ans = 0;
        int start = 0;
        int end = nums.length - 1;
        int middle = (int) (nums.length / 2);

        while(start <= end){
            
            if(target == nums[middle]){
                return target;
            }
            if(target < nums[middle]){
                end = middle - 1;
                best_ans = nums[middle];
            }
            else{
                start = middle + 1;
            }
            middle = (int)(start + end) / 2;
        }

        return best_ans;
    }

    //This is a leetcode easy problem very similar to the above problem
    //https://leetcode.com/problems/find-smallest-letter-greater-than-target/
    //Time Limit Exceeded!

    public char nextGreatestLetter(char[] letters, char target) {
        
        int start = 0;
        int end = letters.length - 1;
        int index = 0;

        while(start <= end && index < 5){
            
            int middle = (start + end) / 2;
            System.out.println("s = "+start + " e = " + end + " m = " + middle);
 
            if(target < letters[middle]){
                end = middle - 1; 
            }
            else{
                start = middle + 1;
            }

            index++;
            
        }
        
        return letters[start%letters.length];
    }
}


