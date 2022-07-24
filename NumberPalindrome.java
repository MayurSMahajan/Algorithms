import java.util.*;
class NumberPalindrome {

    public boolean isPalindrome(int x) {
        if( x < 0){
            return false;
        }
        
        List<Integer> xArr = new ArrayList<Integer>();
        
        while (x > 0 ){
            xArr.add(x % 10);
            x = x / 10;
        }
        
        if(xArr.size() == 1){
            return true;
        }
        
        while(xArr.size() > 1){
            if(xArr.remove(0) != xArr.remove(xArr.size() - 1)){
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args){
        int x = 121;
        NumberPalindrome np = new NumberPalindrome();
        System.out.println(np.isPalindrome(x));
    }
}