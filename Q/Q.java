import java.util.*;

public class Q{
    public static void main(String []ar){
        // QUsingLL q = new QUsingLL(5);
        QUsingLL q = new QUsingLL();
        q.enqueue(7);
        q.enqueue(6);
        q.enqueue(5);
        
        System.out.println("First El of Q -> "+ q.first());
        System.out.println(q.isEmpty());
        
        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }
        System.out.println(q.isEmpty());
        System.out.println("Size of Q is -> "+q.size());
    }
}

class QUsingArr{
    private int[] data;
    private int first;
    private int sz;

    QUsingArr(){}

    QUsingArr(int capacity){
        data = new int[capacity];
    }

    public int size(){
        return sz;
    }   

    public boolean isEmpty(){
        if(sz == 0) 
            return true;
        return false;
    }

    public void enqueue(int e) throws IllegalStateException{
        if(sz == data.length) throw new IllegalStateException("Queue is Full");
        int last = (first+sz) % data.length; 
        data[last] = e;
        sz++;
    }

    public int first(){
        if(isEmpty()) return -1;
        return data[first];
    }

    public int dequeue() throws IllegalStateException{
        if(isEmpty()) throw new IllegalStateException("Queue is empty");
        int ans = data[first];
        first = (first + 1) % data.length;
        sz--;
        return ans;
    }
}

class QUsingLL{
    private LinkedList<Integer> ll;

    QUsingLL(){
        ll = new LinkedList<Integer>();
    }
    
    public int size(){
        return ll.size();
    }

    public boolean isEmpty(){
        if(ll.size() == 0){
            return true;
        }
        return false;
    }

    public void enqueue(int element){
        ll.addLast(element);
    }

    public int first(){
        return ll.peek();
    }

    public int dequeue(){
        return ll.removeFirst();
    }

}
