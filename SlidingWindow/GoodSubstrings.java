import java.util.*;	

class GoodSubstrings{
	public static void main(String[] ar){
		GS g = new GS();
		String s = "aababcabcaababcabcaababcabcaababcabc";
		System.out.println(g.countGoodSubstrings(s)); 
	}
}

class GS {
    public int countGoodSubstrings(String s) {
        int start = 0;
        int end = 2;
        int goodStringCount = 0;

        while(end < s.length()){
            if((s.charAt(start) != s.charAt(start+1)) && (s.charAt(start+1) != s.charAt(end)) && (s.charAt(start) != s.charAt(end))){
                goodStringCount++;
            }
            start++;
            end++;
        }
        return goodStringCount;
    }
}