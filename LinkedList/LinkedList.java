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
    public static int size;

    public void addFirst(int data){ //T.C = O(1)
        //1.Create new Node
        Node newNode = new Node(data);
        size++;
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
        size++;
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

    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx -1){
            temp = temp.next;
            i++;
        }

        // i = idx-1..,i.e temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Removing Elements from Linked List

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;  //IMP LINE
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev: i = size - 2
        Node prev = head;
        for(int i = 0; i <size - 2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //Searching for a key

    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
         
        while(temp != null){
            if(temp.data == key){ //Key Found
                return i;
            }
            temp = temp.next;
            i++;
        }

        //KEy not Found
        return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    public int recSearch(int key){
        return helper(head, key);     
    }

    //Reversing a Linked list

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while( curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Find and Remove the Nth node from the end of the linked list
    public void deleteNthFromEnd(int n){
        //Calculate Size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next; //Remove First
            return;
        }

        //sz-n
        int i = 1;
        int iToFind = sz -n;
        Node prev = head;;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //Palindrome Linked List
    private Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //Find Middle
        Node mid = findMid(head);

        //Reverse 2nd half
        Node curr = mid;
        Node prev = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left =left.next;
            right = right.next;
        }
        return true;
    }

    //Detecting cycle in a linked list
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast != null){
            if(fast == slow){
                return true;
            }
            }else{
                return false;
            }
        }

        return false;
    }

    //Removing a Cycle (1.Cycle? Yes -> make slow = head again)
    //1. find last node
    //2. last node.next = null

    public static void removeCycle(){
        //Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle = false){
            return;
        }

        //Find meeting point
        slow = head;
        Node prev = null; //Last Node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //Remove Cycle -> last.next = null
        prev.next = null;
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next; //Next bcoz first Node is -1
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //Mid Node
    }

    //Merge Sort on LL
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //Find Mid
        Node mid = getMid(head);
        //Left and Right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //Merge
        return merge(newLeft, newRight);
    }

    //Zig zag Pattern
    public void zigZag(){
        //Find Mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //Reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        //Alternate Merge - Zig Zag Merge
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }


    public static void main(String[] args) {
       LinkedList ll = new LinkedList();
       ll.addFirst(4);
       ll.addFirst(2);
       ll.addFirst(1);
       ll.addLast(5);
       ll.addLast(6);
       ll.add(2, 3);
       ll.print();
       System.out.println(LinkedList.size);

       ll.removeLast();
       ll.print();
    }
}
