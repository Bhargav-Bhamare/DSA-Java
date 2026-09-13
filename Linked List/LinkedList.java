public class LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        //1.Create new Node
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        //2. newNode next = head
        newNode.next = head;
        //3. Head = newNode
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }


    public static void main(String[] args) {
       LinkedList ll = new LinkedList();
       ll.addFirst(3);
       ll.addFirst(2);
       ll.addFirst(1);
       ll.addLast(4);
       ll.addLast(5);
    }
}
