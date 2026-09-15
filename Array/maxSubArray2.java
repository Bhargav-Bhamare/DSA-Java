//Prefix Array Approach

class printSubArryas {
    public static void printSubArrays(int nums[]){
        int tpp = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[nums.length];
        
        prefix[0] = nums[0];
        //Prefix array calculation
        for(int i = 1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        
        for(int i=0;i<nums.length;i++){
            int start=i;
            for(int j=i;j<nums.length;j++){
                int sum = 0;
                int end=j;
                if(start == 0){
                    sum = prefix[end];
                }else{
                    sum = prefix[end] - prefix[start-1];
                }
                
                if(sum > maxSum){
                    maxSum = sum;
                }
                tpp++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(" Maximum Sum is :"+ maxSum);
        System.out.print("Total Pairs:"+tpp);
    }
    
    public static void main(String[] args) {
        int nums[]= {2,4,6,8,10};
        printSubArrays(nums);
    }
}

//Time Complexity: O(n^2)------Prefix Array Approach