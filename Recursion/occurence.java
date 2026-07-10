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
    public static void main(String[] args) {
        int arr[] = {2,4,5,7,2,5,9};
        System.out.println(firstOccurence(arr, 5, 0));
    }
}
