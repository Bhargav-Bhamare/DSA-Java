package PracPractice;
import java.util.*;

public class Assign3{
    
    static int[][] multiply(int[][] A, int[][] B, int n) {
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        int m = n / 2;

        int[][] a = new int[m][m];
        int[][] b = new int[m][m];
        int[][] c = new int[m][m];
        int[][] d = new int[m][m];

        int[][] e = new int[m][m];
        int[][] f = new int[m][m];
        int[][] g = new int[m][m];
        int[][] h = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = A[i][j];
                b[i][j] = A[i][j + m];
                c[i][j] = A[i + m][j];
                d[i][j] = A[i + m][j + m];

                e[i][j] = B[i][j];
                f[i][j] = B[i][j + m];
                g[i][j] = B[i + m][j];
                h[i][j] = B[i + m][j + m];
            }
        }

        int[][] p1 = multiply(a, subtract(f, h, m), m);
        int[][] p2 = multiply(add(a, b, m), h, m);
        int[][] p3 = multiply(add(c, d, m), e, m);
        int[][] p4 = multiply(d, subtract(g, e, m), m);
        int[][] p5 = multiply(add(a, d, m), add(e, h, m), m);
        int[][] p6 = multiply(subtract(b, d, m), add(g, h, m), m);
        int[][] p7 = multiply(subtract(a, c, m), add(e, f, m), m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = p5[i][j] + p4[i][j] - p2[i][j] + p6[i][j];
                C[i][j + m] = p1[i][j] + p2[i][j];
                C[i + m][j] = p3[i][j] + p4[i][j];
                C[i + m][j + m] = p1[i][j] + p5[i][j] - p3[i][j] - p7[i][j];
            }
        }

        return C;
    }

    static int[][] add(int[][] A, int[][] B, int n) {
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    static int[][] subtract(int[][] A, int[][] B, int n) {
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = sc.nextInt();

        int[][] C = multiply(A, B, n);

        for (int[] row : C) {
            for (int x : row)
                System.out.print(x + " ");
            System.out.println();
        }

        sc.close();
    }
}
