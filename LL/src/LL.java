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
        System.out.println(temp.val + " -> END");
    }

    public void removeDuplicates(){
        if(head == null){
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
    }

    private class Node {
        int val;
        Node next;
        
        Node(int value){
            val = value;
        }

    }
    
}
