package Greedy;

import java.util.Arrays;

//Code for Sum of minimum absolute differences of all pairs 
public class minDiff {
    public static void main(String[] args) {
        int A[] = {1, 2, 3};
        int B[] = {2, 1, 3};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for(int i =1;i< A.length;i++){
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("Min Absolute of Difference of Pairs = "+minDiff);
    }
}
