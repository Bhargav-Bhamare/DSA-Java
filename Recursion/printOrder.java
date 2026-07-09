public class printOrder {

    public static void printDecending(int n){
        if( n == 1){
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printDecending(n-1);

    }

    public static void printIncreasing(int n){
        if( n == 1){
            System.out.print(n);
            return;
        }
        printIncreasing(n-1);
        System.out.print(n + " ");
        

    }

    public static void main(String[] args) {
       int n = 10;
       printDecending(n);
       printIncreasing(n);
    }
}