import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//LeetCode : https://leetcode.com/problems/reduce-array-size-to-the-half/
public class ReduceArrSizeToHalf {
    public static void main(String[] args) {
        RASTH r = new RASTH();
        int[] test = {1,2,3,4,5,5};
        System.out.println(r.minSetSize(test));
    }
}
/**
 * RASTH
 */
class RASTH {
    public int minSetSize(int[] arr) {
        //Find the frequency of each element and store it in a hash map
        //If all frequencies are 1 then simply return arr.length/2
        //create a new array that stores the frequencies in descending order
        //check if the 1st el in that array is equal or greater than arr.length/2
        //if yes return 1
        //if not add 2nd el value with 1st el value and check if that is >= arr.length/2
        //if yes return 1+1
        
        HashMap<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
        for (int i : arr) {
            if(freqMap.containsKey(i)){
                int curr_freq = freqMap.get(i) + 1;
                if(checkIfSolvedAlready(curr_freq,arr.length/2)){
                    return 1;
                }
                freqMap.put(i, curr_freq); 
            }
            else{
                freqMap.put(i,1); 
            }
        }

        //get all the frequency values in an aray.
        ArrayList<Integer> freqArr = new ArrayList<Integer>();
        for (HashMap.Entry<Integer,Integer> el : freqMap.entrySet()) {
            freqArr.add(el.getValue());
        }

        //sort the freq arr.
        Collections.sort(freqArr, Collections.reverseOrder());  

        int count = 1;
        int collectiveSum = 0;
        for (Integer f : freqArr) {
            if(checkIfSolvedAlready(f + collectiveSum, arr.length/2)){
                return count; 
            }
            else{
                count++;
                collectiveSum += f;
            }
        }

        return 1;
        
    }

    private boolean checkIfSolvedAlready(int fr,int half){
        if(fr >= half){
            return true;
        }
        return false;
    }
}