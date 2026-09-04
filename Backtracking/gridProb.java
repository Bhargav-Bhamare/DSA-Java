package Backtracking;

public class gridProb { //Time Complexity too high
    public static int gridWays(int i, int j,int n, int m){
        //Base Case
        if(i == n-1 && j == m-1){ //Last Cell
            return 1;
        }else if (i == n || j ==m) {
            return 0;
        }
        int w1 = gridWays(i+1, j, n, m); 
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }
    public static void main(String[] args) {
        int n=3,m = 3;
        System.out.println("Total Number of ways: "+gridWays(0, 0, n, m));
    }
}

//To find Total Ways,there can be a simpler approach with less T.C
//It uses permutation and combinatons
//(n-1 + m-1)! / (n-1)!(m-1)!