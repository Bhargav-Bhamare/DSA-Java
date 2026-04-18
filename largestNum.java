class LargestNum {
    public static int getLargest(int nums[]){
        int largest = Integer.MIN_VALUE;    
        for(int i =0;i<nums.length;i++){
            if(largest < nums[i]){
                largest=nums[i];
            }
        }
        return largest;
    }
    
    public static void main(String[] args){
        int nums[]= {12,44,53,16,9,31};
        System.out.print("Largest number is: "+ getLargest(nums));
    }
        
}