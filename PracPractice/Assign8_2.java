package PracPractice;

//Hamiltonian Cycle Problem using Backtracking

public class Assign8_2 {
    static int n = 5;

    static int[][] graph = {
        {0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {1, 1, 0, 0, 1},
        {0, 1, 1, 1, 0}
    };

    static int[] path = new int[n];

    static boolean isSafe(int v, int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    static boolean solve(int pos) {
        if (pos == n) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < n; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;

                if (solve(pos + 1))
                    return true;

                path[pos] = -1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < n; i++)
            path[i] = -1;

        path[0] = 0;

        if (solve(1)) {
            System.out.print("Hamiltonian Cycle: ");

            for (int i = 0; i < n; i++)
                System.out.print((path[i] + 1) + " ");

            System.out.println((path[0] + 1));
        } else {
            System.out.println("No Hamiltonian Cycle exists.");
        }
    }
}
