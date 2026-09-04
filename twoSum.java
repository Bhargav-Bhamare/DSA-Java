public class twoSum {
    
    public static int twoSumProb(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            int currSum =i;
            for(int j=i+1;j<nums.length;j++){
                currSum+=j;
                if(currSum == target){
                    System.out.println("sol found!");
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int nums[] = {3,2,4};
        int target = 6;
        System.out.println(twoSumProb(nums,target));
    }
}
