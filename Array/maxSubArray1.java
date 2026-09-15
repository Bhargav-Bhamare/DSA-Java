//Brute Force Approach

class printSubArryas {
    public static void printSubArrays(int nums[]){
        int tpp = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int start=i;
            
            for(int j=i;j<nums.length;j++){
                int sum = 0;
                int end=j;
                for(int k=start;k<=end;k++){
                    
                    System.out.print(nums[k]+" ");
                    sum+=nums[k];
                }
                //To Print the sum
                System.out.print("Sum: "+ sum);
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

//Time Complexity: O(n^3)------Brute Force Approach