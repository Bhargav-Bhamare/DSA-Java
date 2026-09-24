package LeetCode;
public class Ques {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int high = n /2;
        for(int i = 0;i< n;i++){
            int count = 0;
            count++;
            for(int j=i+1;j<n;j++){
                if(j == i){
                    count++;
                }
            }
            if(count > high){
                return i;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        int nums[] = {3,2,3};
        majorityElement(nums);
    }
}