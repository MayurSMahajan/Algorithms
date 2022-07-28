public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        LL list1 = new LL();
        list1.insertAtFirst(4);
        list1.insertAtFirst(2);
        list1.insertAtFirst(1);
    
        list1.reverseLL();
        // LL list2 = new LL();
        // list2.insertAtFirst(4);
        // list2.insertAtFirst(3);
        // list2.insertAtFirst(1);

        list1.display();
        // list2.display();

        // LL list3 = new LL();
        // list3.mergeTwoSortedLists(list1.getHead(), list2.getHead());
        // list3.display();

        // System.out.print(list3.hasCycles());
        
    }
}


