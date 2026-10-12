package PracPractice;

//Strassen's Matrix Multiplication in Java

public class Assign3 {
    static int[][] mul(int[][] a, int[][] b) {
        int p = (a[0][0] + a[1][1]) * (b[0][0] + b[1][1]);
        int q = (a[1][0] + a[1][1]) * b[0][0];
        int r = a[0][0] * (b[0][1] - b[1][1]);
        int s = a[1][1] * (b[1][0] - b[0][0]);
        int t = (a[0][0] + a[0][1]) * b[1][1];
        int u = (a[1][0] - a[0][0]) * (b[0][0] + b[0][1]);
        int v = (a[0][1] - a[1][1]) * (b[1][0] + b[1][1]);

        return new int[][] {
            {p + s - t + v, r + t},
            {q + s, p + r - q + u}
        };
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};

        int[][] c = mul(a, b);

        for (int[] row : c) {
            for (int x : row)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
