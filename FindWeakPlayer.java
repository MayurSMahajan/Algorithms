//LeetCode daily challenge Sept 9
//https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
import java.util.Arrays;

public class FindWeakPlayer {
    public static void main(String[] args) {
        
        NoOfWeakPlayer nof = new NoOfWeakPlayer();
        int[][] properties = {{7,9},{6,9},{7,5},{10,7},{7,10},{10,4}};
        System.out.println(nof.numberOfWeakCharacters(properties));
    }
}

class NoOfWeakPlayer {
    public int numberOfWeakCharacters(int[][] properties) {
        int ans = 0;
        
        //sort the attacks first in descending order;
        Arrays.sort(properties, (a,b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        
        //now our arr is sorted by the first index
        
        int currentMaxDefence = properties[properties.length - 1][1];
        
        for(int i = (properties.length - 2); i >= 0; i--){
            if(properties[i][1] < currentMaxDefence){
                ans++;
            }
            else{
                currentMaxDefence = properties[i][1];
            }
        }
        
        return ans;
    }
}


//Explanation : 
/* 
We used lambda expression to sort the input. 
The data is sorted in ascending order, but if two sub arrays with attack values same,
then the sub array is sorted in descending order.
Eg:[[1,2],[2,3],[1,1]]
Then after sorting the result will be
[[1,2],[1,1],[2,3]]

//we do this bcz the question states that one subarray should be STRICTLY greater than other.
*/