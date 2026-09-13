package LinkedList;

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

    public void addFirst(int data){ //T.C = O(1)
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
    public void addLast(int data){  //T.C = O(1)
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
       LinkedList ll = new LinkedList();
       ll.addFirst(3);
       ll.addFirst(2);
       ll.addFirst(1);
       ll.addLast(4);
       ll.addLast(5);

       ll.print();
    }
}
