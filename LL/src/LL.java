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

    public void reverseLL(){
        head = reverseRecursion(head);
    }

    private Node reverseRecursion(Node n){
        if(n.next == null){
            head = n;
            return head;
        }
        else{
            head.next = reverseRecursion(n.next);
            return n.next;
        }
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

    //Solution for Linked List Cycle LeetCode#141
    public boolean hasCycles(){
        Node fast = head;
        Node slow = head;

        while (fast != null && slow != null) {
            if(fast.next != null){
                fast = fast.next.next;
            }
            else{
                return false;
            }
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //LeetCode : https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
    public int getDecimalValue() {
        //lets find the total number of nodes in ll
        int ll_size = 0;
        Node temp = head;
        while(temp.next != null){
            ll_size++;
            temp = temp.next;
        }
        
        if(ll_size == 0){
            return head.val;
        }
        
        //Now we have the size of ll so we know the total no. of bits in our bin no.
        //our msb's base value will be ll_size * 2.
        int base_val = (int) Math.pow(2.0,(int)ll_size);
        temp = head;
        
        int decimal_ans = 0;
        while(temp != null){
            decimal_ans += (base_val * temp.val);
            base_val /= 2;
            temp = temp.next;
        }
        
        return decimal_ans;
    }

    //Middle of the Linked List
    //https://leetcode.com/problems/middle-of-the-linked-list/
    public Node middleNode() {
        //we will solve this using two pointers.
        Node fast = head;
        Node slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast.next != null){
            //this means the list has even no. of nodes
            return slow.next;
        }
        else{
            //this means the list has odd no. of nodes
            return slow;
        }
    }
    
    //Delete the Middle of the Linked List
    //heavily similar to the problem above, rather than returning the middle we just change the previous to middle to point to the next to middle.
    //https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/
    //5ms faster than 73% uses 63.5mb less than 81%.
    public ListNode deleteMiddle() {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast != null){
            fast = fast.next;
            count++;
        }
        if(count == 1) return null;
        count /=2;
        while(count > 1){
            slow = slow.next;
            count--;
        }
        slow.next = slow.next.next;
        return head;
    }
    

    //LeetCode Reverse LL Iteratively - 
    //https://leetcode.com/problems/reverse-linked-list/
    public Node reverseList() {
        
        if(head == null || head.next == null) return head;
        
        Node prev = null;
        Node current = head;
        
        Node future = head.next;
        
        while(current != null){
            current.next = prev;
            prev = current;
            current = future;
            if(future != null){
                future = future.next;
            }
        }
        head = prev;
         
        
        return head;
    }

    private class Node {
        int val;
        Node next;
        
        Node(int value){
            val = value;
        }

    }

    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
    //leetcode signature - public ListNode removeNthFromEnd(ListNode head, int n) {
    public Node removeNthFromEnd(int n) {
        
        
        Node pointToEnd = head;
        Node pointToElement = head;
        Node pointPrev = null;
        
        while((n-1) > 0){
            n--;
            pointToEnd = pointToEnd.next;
        }
        
        while(pointToEnd.next != null){
            pointToEnd = pointToEnd.next;
            pointPrev = pointToElement;
            pointToElement = pointToElement.next;
        }
        
        if(pointPrev != null){
            pointPrev.next = pointToElement.next;    
        }
        else{
            head = head.next;
        }
        
        return head;
    }
    
    
    //143. Reorder List
    //https://leetcode.com/problems/reorder-list/
    //using stack
    public void reorderList(ListNode head) {
        if(head.next == null)  return;
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        
        temp = head;
        int count = stack.size() /2;
        
        while(count > 0){
            ListNode top = stack.pop();
            ListNode newTemp = temp.next;
            temp.next = top;
            temp = newTemp;
            top.next = temp;
            count--;
        }
        
        temp.next = null;
    }
    
    //143. Reorder List
    //https://leetcode.com/problems/reorder-list/
    //without stack
    public void reorderListSlow(ListNode head) {
        if(head.next == null) return;
        ListNode start = head;
        ListNode end = head;
        while(end.next.next != null){
            end = end.next;
        }
        //insert the last element after the first element
        while(start != end && start != end.next){
            ListNode temp = start.next;
            start.next = end.next;
            end.next = null;
            start = start.next;
            start.next = temp;
            
            start = start.next;
            end = head;
            while(end.next.next != null){
                end = end.next;
            }
        }
    }
    
}
