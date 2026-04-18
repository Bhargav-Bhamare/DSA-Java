class binarySearch{
    public static int binarySearch(int nums[], int key){
        int start =0,end = nums.length-1;
        
        while(start<=end){
            int mid = (start + end) / 2;
            
            //Comparisons
            if(nums[mid] == key){
                return mid;
            }
            if(nums[mid] < key){
                start = mid+1;
            }
            if(nums[mid] > key){
                end = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
        int nums[]= {12,24,35,46,56,68,79};
        int key = 68;
        System.out.print("Key Found At index: "+ binarySearch(nums,key));
    }
        
}

//Time Complexity: O(log n) 
//Space Complexity: O(1) 