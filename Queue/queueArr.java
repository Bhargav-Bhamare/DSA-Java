package Queue;

public class queueArr {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        Queue(int n){
            arr= new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }
        //Adding Elements in a Queue
        public static void add(int data){
            if(rear == size -1){
                System.out.println("Queue is Full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }


    }
}
