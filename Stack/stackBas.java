package Stack;
import java.util.*;

public class stackBas {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0;
        }
        //Push
        public static void push(int data){
            list.add(data);
        }

        //Pop
        public static int pop(){
            int top = list.get(list.size() -1);
            list.remove(list.size() - 1);
            return top;
        }

        
    }
}
