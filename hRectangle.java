class hRectangle {
    public static void hollow_Rectangle(int totalRows, int totalCols){
        //outer loop
        for(int i =1;i<=totalRows;i++){
            //inner loop
            for(int j = 1;j<=totalCols;j++){
                //cell - (i-j)
                if( i == 1 || i == totalRows || j == 1 || j == totalCols){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        hollow_Rectangle(24,28);
    }
}