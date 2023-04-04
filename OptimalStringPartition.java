// 2405. Optimal Partition Of Substring
// https://leetcode.com/problems/optimal-partition-of-string
// faster than 50% and uses 19% less memory

import java.util.HashSet;

public class OptimalStringPartition {
    public static void main(String[] args) {
        OptimalStringPartitionSolution o = new OptimalStringPartitionSolution();
        System.out.println(o.partitionString("abacaba"));
        System.out.println(o.partitionString("hdklqkcssgxlvehva"));
        System.out.println(o.partitionString("ssssss"));
    }
}

class OptimalStringPartitionSolution {

    public int partitionString(String s) {
        int ans = 0;
        HashSet set = new HashSet();

        for(char c : s.toCharArray()){
            if(set.contains(c)){
                ans++;
                set.clear();
                set.add(c);
            }else{
                set.add(c);
            }
        }
        return ans+1;
    }
}
