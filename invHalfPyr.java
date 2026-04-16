class invHalfPyr {
    public static void invHalfPyr(int n){
        //outer loop
        for(int i = 1;i<=n;i++){
            //innerloop
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        invHalfPyr(4);
    }
}