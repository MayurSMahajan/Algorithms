import java.util.Arrays;

// 75% faster and uses 20% less memory
// 2300 https://leetcode.com/problems/successful-pairs-of-spells-and-potions

public class SpellsAndPotions {
    public static void main(String[] args) {
        int[] spells = {3,1,2};
        int[] potions = {8,5,8};
        int success = 16;
        SaP s = new SaP();
        int[] ans = s.successfulPairs(spells, potions, success);
        for(int a : ans){
            System.out.println(a);
        }
    }
}

class SaP{
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        //sort the potions array.
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++){
            double target = (double) success/spells[i];
            int start = 0;
            int end = potions.length - 1;

            while(start <= end ) {
                int mid = start + ((end - start) / 2) ;
                if (potions[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            ans[i] = potions.length - end - 1;
        }
        return ans;
    }

    /* Brute Force Solution - TLE
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        //sort the potions array.
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++){
            double lb = (double) success/spells[i];
            int potionsIndex = potions.length - 1;
            while(potionsIndex >= 0){
                if(potions[potionsIndex] < lb){
                    break;
                }
                potionsIndex--;
            }
            ans[i] = potions.length - potionsIndex - 1;
        }
        return ans;
    }
    */
}
