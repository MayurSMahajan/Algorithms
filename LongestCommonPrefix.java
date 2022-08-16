import java.lang.Math;

class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"car","cart","ca"};
        System.out.println(longestCommonPrefix(arr));
        
    }
    
    public static String longestCommonPrefix(String[] strs) {
        String coms = strs[0];
        String ans = "";
        
        for(int i=1;i<strs.length;i++){
            int min = Math.min(coms.length(),strs[i].length());
            for(int j=0;j<min;j++){
                if(coms.charAt(j) != strs[i].charAt(j)){
                    break;
                }
                else{
                    ans += coms.charAt(j);
                }
                
            }
            coms = ans;
            ans = "";
            
        }
        return coms;
    }
    
}
