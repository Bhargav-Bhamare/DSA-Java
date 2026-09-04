public class twoSum {
    
    public static void twoSumProb(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            int currSum =nums[i];
            for(int j=i+1;j<nums.length;j++){
                currSum+=nums[j];
                if(currSum == target){
                    System.out.println("Index of the two numbers are: "+i+" and "+j);
                }
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        twoSumProb(nums,target);
    }
}
