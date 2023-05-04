// 649. Dota2 Senate
// https://leetcode.com/problems/dota2-senate
// faster 65% submissions, and only 32% memory efficient

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public static void main(String[] args) {
        String senate1 = "DDRRDRRRRDR";
        String senate2 = "DDRRR";
        Dota2SenateSolution d = new Dota2SenateSolution();
        System.out.println(d.predictPartyVictory(senate1));
        System.out.println(d.predictPartyVictory(senate2));
    }
}

class Dota2SenateSolution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> Rqueue = new LinkedList<>();
        Queue<Integer> Dqueue = new LinkedList<>();
        int senateLength = senate.length();

        for(int i=0; i<senateLength; i++){
            if(senate.charAt(i) == 'R'){
                Rqueue.add(i);
            }else{
                Dqueue.add(i);
            }
        }

        while(!Rqueue.isEmpty() && !Dqueue.isEmpty()){
            int rTop = Rqueue.remove();
            int dTop = Dqueue.remove();

            if(rTop < dTop){
                Rqueue.add(rTop + senateLength);
            }else{
                Dqueue.add(dTop + senateLength);
            }
        }

        return Rqueue.isEmpty() ? "Dire" : "Radiant";

    }
}
