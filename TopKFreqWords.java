import java.util.*;

/*
 * Problem : https://leetcode.com/problems/top-k-frequent-words/
 * 
 * Approach :
 * We will divide the given problem into sub-problems:
 * 1. Store the frequency of words using HashMap
 * 2. Get the values of the hash map in an array.
 * 3. Sort the array and get the k most frequent elements.
 * 4. Check if the value of frequencies to find mathcing frequency count.
 * 5. Design a function for sorting the words with matching frequencies and add them to final ans
 */

public class TopKFreqWords {
    public static void main(String[] args) {
        TKFW tkfw = new TKFW();
        String[] words = {"the","day","is","sunny","the","sunny","is","is"};
        System.out.println(tkfw.topKFrequent(words, 2));
    }
}

class MyHashMap{
    List<MyHashEntry> map;

    MyHashMap(){
        map = new ArrayList<MyHashEntry>();
    }

    public void put(MyHashEntry newEntry){
        map.add(newEntry);
    }

    public List<MyHashEntry> getKMostFrequent(int k){

        List<MyHashEntry> kMostList = new ArrayList<MyHashEntry>();
        
        while(k > 0){
            kMostList.add(getMostFreq());
            k--;
        }
        
        return kMostList;
    }

    public MyHashEntry getMostFreq(){
        MyHashEntry ans = map.get(0);

        for (MyHashEntry el : map) {
            if(el.getValue() > ans.getValue()){
                ans = el;
            }else if(el.getValue() == ans.getValue()){
                ans = sortLexically(ans, el);
            }
        }

        map.remove(ans);
        return ans;
    }

    private MyHashEntry sortLexically(MyHashEntry el1, MyHashEntry el2){
        if(el1.getKey().compareTo(el2.getKey()) < 0){
            return el1;
        }
        else{
            return el2;
        }
    }

}

class MyHashEntry{
    String word;
    Integer frequency;

    MyHashEntry(String word, Integer frequency){
        this.word = word;
        this.frequency = frequency;
    }

    String getKey(){
        return word;
    }

    Integer getValue(){
        return frequency;
    }
}

class TKFW{
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<String>();

        HashMap<String, Integer> fMap = new HashMap<String, Integer>();

        for (String word : words) {
            if(fMap.get(word) == null){
                fMap.put(word, 1);    
            }
            else{
                fMap.put(word, fMap.get(word) + 1);
            }
            
        }

        MyHashMap myHashMap = new MyHashMap();

        for (Map.Entry<String, Integer> mapEl : fMap.entrySet()) {
            MyHashEntry temp = new MyHashEntry(mapEl.getKey(),mapEl.getValue());
            myHashMap.put(temp);
        }

        for (MyHashEntry mEntry : myHashMap.getKMostFrequent(k)) {
            ans.add(mEntry.getKey());
        }

        return ans;
    }
}
