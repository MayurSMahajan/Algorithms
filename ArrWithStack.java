//https://leetcode.com/problems/build-an-array-with-stack-operations/
import java.util.*; 

public class ArrWithStack{
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<String>(); 
        
        n = target[target.length - 1];
        
        for(int i = 1; i <= n; i++){
            list.add("Push");
            if(!contains(target, i)){
                list.add("Pop");
            }
        }
        
        return list;
    }
    
    public boolean contains(int[] arr, int el){
        for(int j : arr){
            if(j == el) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        ArrWithStack aws = new ArrWithStack();
        int[] t_arr = {1,3};
        List<String> l = aws.buildArray(t_arr,5);
        
        for(String a : l){
            System.out.println(a);
        }
    }
}
