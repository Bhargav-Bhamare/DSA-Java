package Stack;

import java.util.*;

public class nextGreater {
    public static void main(String[] args) {
        int arr[] = {3,2,1,5,0,8};
        Stack<Integer> s  = new Stack<>();
        int nextGrtr[] = new int[arr.length];

        for(int i = arr.length-1;i >=0;i--){
            //1.While loop
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            //2. if-else
                if(s.isEmpty()){
                    nextGrtr[i] = -1;
                }else{
                    nextGrtr[i] = arr[s.peek()];
                }

            //3. Push in stack
            s.push(i);
        }

        for(int i =0;i< nextGrtr.length;i++){
            System.out.print(nextGrtr[i]+" ");
        }
        System.out.println();
    }
}
