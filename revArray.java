class revArray{
    public static void reverseArray(int nums[]){
        int first =0, last = nums.length-1;
        
        while(first < last){
            int temp = nums[last];
            nums[last] = nums[first];
            nums[first] = temp;
            
            first++;
            last--;
        }
    }
    
    public static void main(String[] args){
        int nums[]= {12,24,35,46,56,68,79};
        reverseArray(nums);
        
        for(int i =0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
        
}

//Time Complexity: O(n) 
//Space Complexity: O(1)