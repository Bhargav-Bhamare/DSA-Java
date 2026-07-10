public class occurence {

    public static int firstOccurence(int arr[], int key, int i){
        if(i == arr.length-1){
            return -1;
        }
        
        if( arr[i] == key){
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence(int arr[], int key, int i){
        if(i == arr.length-1){
            return -1;
        }
        //Look Forward
        int isFound = lastOccurence(arr, key, i+1);
        if( isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,5,7,2,5,9};
        System.out.println(lastOccurence(arr, 5, 0));
    }
}
