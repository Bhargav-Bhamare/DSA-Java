package Stack;
import java.util.*;


public class histogram {
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next Smaller Right
        Stack<Integer> s = new Stack<>();

        for(int i =arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Smaller left
        s = new Stack<>();

        for(int i =0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Current area
        for(int i =0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] -1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("Max area in histogram is : "+ maxArea);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};  
        maxArea(arr);
    }
}

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int maxArea = 0;
//         int nsr[] = new int[heights.length];
//         int nsl[] = new int[heights.length];

//         //Next Smaller Right
//         Stack<Integer> s = new Stack<>();

//         for(int i =heights.length-1;i>=0;i--){
//             while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 nsr[i] = heights.length;
//             }else{
//                 nsr[i] = s.peek();
//             }
//             s.push(i);
//         }

//         //Next Smaller left
//         s = new Stack<>();

//         for(int i =0;i<heights.length;i++){
//             while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 nsr[i] = heights.length;
//             }else{
//                 nsr[i] = s.peek();
//             }
//             s.push(i);
//         }

//         //Current area
//         for(int i =0;i<heights.length;i++){
//             int height = heights[i];
//             int width = nsr[i] - nsl[i] -1;
//             int currArea = height * width;
//             maxArea = Math.max(currArea, maxArea);
//         }

//         return maxArea;
//     }
// }