class printPair {
    public static void printPairs(int nums[]){
        int tpp = 0;
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            
            for(int j=i+1;j<nums.length;j++){
                System.out.print("("+ curr+","+nums[j]+")");
                tpp++;
            }
            System.out.println();
        }
        System.out.print("Total Pairs:"+tpp);
    }
    
    public static void main(String[] args) {
        int nums[]= {2,4,6,8,10};
        printPairs(nums);
    }
}