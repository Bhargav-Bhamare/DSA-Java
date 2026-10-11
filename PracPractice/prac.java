package PracPractice;

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
        System.out.println();
        int n  =2;
        towerOfHanoi(n, "A", "B","C");
    }
}
