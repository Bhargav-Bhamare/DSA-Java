package PracPractice;

//Floyd Warshall Algorithm in Java
public class Assign9_2 {
    public static void main(String[] args) {
        int INF = 99999;

        int[][] dist = {
            {0,   5,   INF, 10},
            {INF, 0,   3,   INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };

        int n = dist.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }

        System.out.println("All Pairs Shortest Distance Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
