class floydTriangle {
    public static void Pyr(int n){
        //outer loop
        int counter =1;
        for(int i = 1;i<=n;i++){
            //innerloop
            for(int j=1;j<=i;j++){
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Pyr(14);
    }
}