// 2215. Find the Difference of Two Arrays
// https://leetcode.com/problems/find-the-difference-of-two-arrays/
// Faster than 86% submissions and memory wise 6% efficient than others.

import java.util.*;

public class ArrayDifference {
    public static void main(String[] args) {
        ArrayDifferenceSolution ads = new ArrayDifferenceSolution();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println(ads.findDifference(nums1, nums2));
    }
}

class ArrayDifferenceSolution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();;
        //first populate a hashmap with the second array elements
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for (int el : nums2) {
            map.put(el, true);
        }

        //traverse through the first array to populate answer
        List<Integer> helperList = new ArrayList<Integer>();
        HashSet<Integer> helperSet = new HashSet<Integer>();

        for(int el : nums1){
            if(!map.containsKey(el) && !helperSet.contains(el)){
                helperList.add(el);
                helperSet.add(el);
            }else{
                //since element is already in map, we update its value to 1
                //this denotes that the element is common in both arrays.
                map.put(el, false);
            }
        }
        ans.add(0,helperList);

        //traverse through the map to find the uncommon elements
        List<Integer> helperList2 = new ArrayList<Integer>();
        for (Map.Entry<Integer, Boolean> mapEl : map.entrySet()) {
           if(mapEl.getValue()){
               helperList2.add(mapEl.getKey());
           }
        }
        ans.add(1,helperList2);

        return ans;
    }
}