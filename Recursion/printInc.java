public class printInc {

    public static void printIncreasing(int n){
        if( n == 10){
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printIncreasing(n + 1);
    }
    public static void main(String[] args) {
        int n = 1;
        printIncreasing(n);
    }
}
