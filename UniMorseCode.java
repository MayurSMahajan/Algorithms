// LeetCode https://leetcode.com/problems/unique-morse-code-words/
import java.util.HashMap;

public class UniMorseCode {
    public static void main(String[] args) {
        UniqueMorseCodeWordsMayur umc = new UniqueMorseCodeWordsMayur();
        String[] words = {"rwjje","aittjje","auyyn","lqtktn","lmjwn"};
        // String[] words = {"gin","zen","gig","msg"};
        int ans = umc.uniqueMorseRepresentations(words);
        System.out.println("Answer = "+ans);
    }
}

/**
 * UniqueMorseCodeWords
 */
class UniqueMorseCodeWordsMayur {
    UniqueMorseCodeWordsMayur(){}

    public int uniqueMorseRepresentations(String[] words) {
        HashMap<String,String> morseMap = new HashMap<String,String>();
        String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] alphabets = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        //creating a dictionary of alphabets to morse code conversion
        for (int i = 0; i < alphabets.length; i++) {
            morseMap.put(alphabets[i], morseCodes[i]);
        }

        HashMap<String,Integer> morseFreq = new HashMap<String,Integer>();
        for (int i = 0; i < words.length; i++) {
            //convert each word in its respective morse code transformation
            String[] charsOfWord =
            words[i].split("");
            String morseCode = "";
            
            for (int j = 0; j < charsOfWord.length; j++) {
                morseCode += morseMap.get(charsOfWord[j]);
            }
            System.out.println("Value of Morse Code : "+morseCode);
            
            //check if the morseCode already exists in the morseFreq, if it does then increment its frequency count.
            if(morseFreq.containsKey(morseCode)){
                morseFreq.put(morseCode, morseFreq.get(morseCode) + 1);
            }
            else{
                morseFreq.put(morseCode, 1);
            }
        }

        int ans = morseFreq.size();

        return ans;
    }
}