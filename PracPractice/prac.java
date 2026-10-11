package PracPractice;

import java.util.ArrayList;

public class prac {

    //Tower of hanoi
    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 1){
            System.out.println("Move Disk "+n+" from "+ src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Move Disk "+n+" from "+ src+" to "+dest);
        towerOfHanoi(n-1, helper,src, dest);
    }

    public static void main(String[] args) {
        int arr[] = {4,1,2,6,9};
        
        // for(int i =0;i< arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }
        //System.out.println();
        int start[] ={1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(0);
        int lastEndTime = end[0];
        for(int i = 0;i<end.length;i++){
            if(start[i] >= lastEndTime){
                //Select the activity
                maxAct++;
                ans.add(i);
                lastEndTime = end[i];
            }
        }
        System.out.println("Max Activities: " + maxAct);
        for(int i = 0;i< ans.size();i++){
            System.out.println("A"+ans.get(i));
        }
        System.out.println();
    }
}
