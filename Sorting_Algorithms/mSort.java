package Sorting_Algorithms;

public class mSort{

    //Merge Method to merge the sorted parts 
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si; //idx for first sorted part
        int j = mid+1; //idx for 2nd sorted part
        int k = 0;  //idx fot temp

        while(i <= mid && j<= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //for remaining leftover elements of 1st part
        while(i<= mid){
            temp[k++] = arr[i++];
        }
        //for remaining leftover elements of 2nd part
        while(i<= mid){
            temp[k++] = arr[i++];
        }
    }

    public static void mergeSort(int arr[],int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr, si, mid, ei);
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        // printArr(arr);
    }
}