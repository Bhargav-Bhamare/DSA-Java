public class twoSum {
    
    public static void twoSumProb(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            int currSum =i;
            for(int j=i+1;j<nums.length;j++){
                currSum+=j;
                if(currSum == target){
                    System.out.println("Index of the two numbers are: "+i+" and "+j);
                }
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {3,2,4};
        int target = 6;
        twoSumProb(nums,target);
    }
}
