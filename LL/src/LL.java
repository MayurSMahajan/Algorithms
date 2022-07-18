public class LL {
    
    private Node head;
    

    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void display(){
    
        if(head == null) {
            System.out.print("LL is empty");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.val + " -> END");
    }

    private class Node {
        int val;
        Node next;
        
        Node(int value){
            val = value;
        }

    }
    
}
