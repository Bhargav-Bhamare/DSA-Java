public class printDec {

    public static void printDecending(int n){
        if( n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDecending(n-1);

    }

    public static void main(String[] args) {
       int n = 10;
       printDecending(n);
    }
}