package Queue;

public class queueLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
        static Node head = null;
        static Node tail = null;

        //isEmpty
        public static boolean isEmpty(){
            return head == null & tail == null;
        }

        //Add
        public static void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return ;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //Remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int front = head.data;
            //Single Element
            if(tail == head){
                tail = head = null;
            }else{
                head = head.next;
            }
            return front;
        }

        //Peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return head.data;
        }
    }


}
