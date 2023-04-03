// 881. Boats to Save People
// https://leetcode.com/problems/boats-to-save-people/
// 98% faster but only 6% memory efficient

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        BoatsToSavePeopleSolution bts = new BoatsToSavePeopleSolution();
        System.out.println(bts.numRescueBoats(people, 3));
    }
}

class BoatsToSavePeopleSolution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        int start = 0;
        int end = people.length - 1 ;

        Arrays.sort(people);

        while(people[end] >= limit){
            end--;
            ans++;
        }

        while(start < end){
            if(people[start] + people[end] <= limit){
                ans++;
                end--;
                start++;
            }else{
                end--;
                ans++;
            }
        }

        return ans + 1;
    }
}