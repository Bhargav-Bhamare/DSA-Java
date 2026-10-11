package PracPractice;


// import java.util.*;

public class Assign8 {
    public static void main(String[] args) {

        //Vertex Cover Problem using Greedy Algorithm
        int vertices = 5;

        // Edges: (u, v)
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {1, 3},
            {3, 4}
        };

        boolean[] visited = new boolean[edges.length];
        boolean[] cover = new boolean[vertices];

        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                int u = edges[i][0];
                int v = edges[i][1];

                cover[u] = true;
                cover[v] = true;

                // Remove all edges connected to u or v
                for (int j = 0; j < edges.length; j++) {
                    if (edges[j][0] == u || edges[j][1] == u ||
                        edges[j][0] == v || edges[j][1] == v) {
                        visited[j] = true;
                    }
                }
            }
        }

        System.out.print("Vertex Cover: ");
        for (int i = 0; i < vertices; i++) {
            if (cover[i])
                System.out.print(i + " ");
        }
    }
}
