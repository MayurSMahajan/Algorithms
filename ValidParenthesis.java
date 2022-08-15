//Solution for problem https://leetcode.com/problems/valid-parentheses/

import java.util.*;
import java.io.*;

class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }
    
    public static boolean isValid(String s){
        String[] str = s.split("");
        
        Stack<String> stack1 = new Stack<String>();
        System.out.println(stack1);
        
        for (String c : str){
            if(stack1.empty()){
                if(c.equals("(") || c.equals("[") || c.equals("{") ){
                    stack1.add(c);  
                    System.out.println(stack1);
                }
                else {
                    System.out.println("The char that returned "+c);
                    return false;
                }
            }
            else{
                System.out.println(stack1);
                String e = stack1.pop();
                if((c.equals(")") && !e.equals("(")) || (c.equals("}") && !e.equals("{")) || (c.equals("]") && !e.equals("[")) )
                    return false;
                    
                if((e.equals("(") && !c.equals(")")) || (e.equals("{") && !c.equals("}")) || (e.equals("[") && !c.equals("]"))){
                    stack1.push(e);
                    stack1.push(c);
                    System.out.println(stack1);
                }
            }
        }
        
        return stack1.empty();
    }
}

