package PracPractice;


public class Assign7 {
    static int n = 4;
    static int[][] cost = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };

    static int min = 9999;

    static void tsp(int city, int count, int total, boolean[] v) {
        if (count == n && total + cost[city][0] < min) {
            min = total + cost[city][0];
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i] && total + cost[city][i] < min) {
                v[i] = true;
                tsp(i, count + 1, total + cost[city][i], v);
                v[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        boolean[] v = new boolean[n];
        v[0] = true;

        tsp(0, 1, 0, v);

        System.out.println("Minimum Cost: " + min);
    }
}