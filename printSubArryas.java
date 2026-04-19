class printSubArryas {
    public static void printSubArrays(int nums[]){
        int tpp = 0;
        for(int i=0;i<nums.length;i++){
            int start=i;
            for(int j=i;j<nums.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(nums[k]+" ");
                }
                tpp++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("Total Pairs:"+tpp);
    }
    
    public static void main(String[] args) {
        int nums[]= {2,4,6,8,10};
        printSubArrays(nums);
    }
}