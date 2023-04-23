// 57. Insert Interval ~ Medium
// https://leetcode.com/problems/insert-interval
// beats 97.87% time and 65% memory usage.

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        InsertIntervalSolution iis = new InsertIntervalSolution();
        int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newInterval = {4,8};
        intervals = iis.insert(intervals, newInterval);

        for(int[] interval : intervals){
            for (int i : interval){
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }
}

class InsertIntervalSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for(int[] interval : intervals){
            if(interval[0] > newInterval[1]){
                result.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                result.add(interval);
            } else{
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        result.add(newInterval);

        int[][] ans = new int[result.size()][2];
        for (int index = 0; index < result.size(); index++) {
            ans[index] = result.get(index);
        }
        return ans;
    }
}