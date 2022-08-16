import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQ {
    public static void main(String[] args) {
        SUQ s1 = new SUQ();
        s1.push(5);
        s1.push(7);
        s1.push(3);
        System.out.println(s1.pop());
        System.out.println(s1.empty());
        System.out.println(s1.top());
        System.out.println(s1.pop());
        s1.push(6);
        s1.push(2);
        System.out.println(s1.empty());
        System.out.println(s1.pop());

    }
}

/**
 * Stack Using Queues LINK: https://leetcode.com/problems/implement-stack-using-queues/
 */
class SUQ {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public SUQ() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        while(!(q1.size() == 1)){
            q2.add(q1.remove());
        }
        int ans = q1.remove();
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return ans;
    }
    
    public int top() {
        
        while(!(q1.size() == 1)){
            q2.add(q1.remove());
        }
        int ans = q1.peek();
        q2.add(q1.remove());
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return ans;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }    
}
