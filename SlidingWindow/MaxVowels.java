// 1456. Maximum Number of Vowels in a Substring of Given Length
// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
// faster than 64% and 76% memory efficient

public class MaxVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        String s1 = "aeiou";
        String s2 = "abciiidef";
        String s3 = "abc";
        MaxVowelsSolution ms = new MaxVowelsSolution();
        System.out.println(ms.maxVowels(s,3));
        System.out.println(ms.maxVowels(s1,2));
        System.out.println(ms.maxVowels(s2,3));
        System.out.println(ms.maxVowels(s3,1));
    }
}
class MaxVowelsSolution {
    public int maxVowels(String s, int k) {
            int ans = 0;
            int startIndex = 0;
            int endIndex = k - 1;
        int vowelsInStartWindow = 0;

        //initially we need to check all chars of the window.
        for (int i = startIndex; i <= endIndex; i++) {
            if(isVowel(s.charAt(i))){
                vowelsInStartWindow++;
            }
        }
        startIndex++;
        endIndex++;
        ans = vowelsInStartWindow;

        while(endIndex < s.length()){
            int vowelsInCurrWindow = vowelsInStartWindow - (isVowel(s.charAt(startIndex-1)) ? 1 : 0);
            vowelsInCurrWindow += (isVowel(s.charAt(endIndex)) ? 1 : 0);
            startIndex++;
            endIndex++;
            vowelsInStartWindow = vowelsInCurrWindow;
            ans = Math.max(vowelsInCurrWindow, ans);
        }

        return ans;
    }

    boolean isVowel(char c){
        return (c == 'a' || c == 'u' || c == 'o' || c == 'i' || c == 'e' );
    }

    int maxVowelsBruteForce(String s, int k){
        int ans = 0;
        int startIndex = 0;
        int endIndex = k - 1;
        while(endIndex < s.length()){
            int vowelsInWindow = 0;
            for(int i = startIndex; i <= endIndex; i++){
                if(isVowel(s.charAt(i))){
                    vowelsInWindow++;
                }
            }
            ans = Math.max(vowelsInWindow, ans);
            startIndex++;
            endIndex++;
        }
        return ans;
    }
}