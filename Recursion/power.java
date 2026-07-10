public class power {

    //Time Complexity = O(n)---Too high,therefore we go towards Optimized approach
    public static int calcPower(int x, int n){
        if( n == 0){
            return 1;
        }
        int X = x * calcPower(x, n-1);
        return X;
    }

    //Time Complexity = O(Log n)
    public static int optimizedPower(int a, int n){
        if(n == 0){
            return 1;
        }

        int halfPower = optimizedPower(a, n/2);
        int halfPowerSq = halfPower * halfPower;
        //Odd
        if( n % 2 != 0){
            halfPowerSq = a * halfPowerSq;
        }

        return halfPowerSq;
    }


    public static void main(String[] args) {
        System.out.println(optimizedPower(2, 10));
    }
}
