class Solution {
    public int reverse(int x) {
        
        long ans;
        boolean isNegative = false;
        
        if(x < 0){
            isNegative = true;
            x = x * (-1);
        }
        
        StringBuilder strb = new StringBuilder(String.valueOf(x));
        strb = strb.reverse();
        String ansStr = strb.toString();
        
        try{
            ans = Long.parseLong(ansStr);    
        }
        catch(NumberFormatException ne){
            return 0;
        }
        
        if(ans > Integer.MAX_VALUE){
            return 0;
        }
        
        ans = isNegative ? (ans * -1) : ans;
        int finalResult = (int) ans;
        return finalResult;
    }
}
