class LinearSearch{
    public static int linearSearch(int nums[], int key){
         for(int i=0;i<nums.length;i++){
            if(nums[i] == key){
                return i;
            }
            
        }
        return -1;
    }
    
    public static void main(String[] args){
        
        int nums[]= {2,4,3,6,9,1};
        int key = 6;
        
        int output = linearSearch(nums,key);
        if(output == -1){
            System.out.print("Key Not Found");
        }else{
            System.out.print("Key Found at "+output);
        }
    }
}