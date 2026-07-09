public class factorial {

    public static int Fact(int n){
        if( n == 0){
            return 1;
        }
        int fact = n * Fact(n-1);
        return fact;
    }

    public static int SumOfN(int n){
        if( n == 1){
            return 1;
        }
        int fact = n + SumOfN(n-1);
        return fact;
    }

    public static void main(String[] args) {
        int n = 5;
        
        System.out.println("Factorial of the given number is : " + Fact(n));
    }
}

//Time Complexity = O(n)

//Space Complexity = O(n)
