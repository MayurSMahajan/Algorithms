public class LL {
    
    private Node head;

    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public Node getHead(){
        return head;
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

    //Solution of LeetCode problem number 83
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

    //Cleaner code since I am able to separate my code from the actual leetcode solution.
    public void mergeTwoSortedLists(Node l1, Node l2){
        head = mergeTwoSorted(l1, l2);
    }

    //Solultion for Merge Two Sorted Lists in LeetCode problem no 21
    public Node mergeTwoSorted(Node l1, Node l2){
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 != null && l2 == null) {
            return l1;
            
        }
        if (l2 != null && l1 == null){
            return l2;
        }
        
        Node l3 = null;
        Node t3;
        Node fl3 = null;

        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                t3 = l1;
                l1 = l1.next;
            }
            else{
                t3 = l2;
                l2 = l2.next;
            }

            if (l3 != null) {
                l3.next = t3;
                l3 = l3.next;
            }
            else{
                fl3 = t3;
                l3 = t3;
            }
        }

        if(l1 != null && l2 == null){
            l3.next = l1;
            return fl3;
        }
        if(l2 != null && l1 == null){
            l3.next = l2;
            return fl3;
        }
        
        return fl3;
        
        
    }

    private class Node {
        int val;
        Node next;
        
        Node(int value){
            val = value;
        }

    }
    
}
