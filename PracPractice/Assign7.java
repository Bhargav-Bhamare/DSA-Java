package PracPractice;
//traveling salesman problem using branch and bound

import java.util.*;

public class Assign7 {
    static int n = 4;
    static int[][] cost = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };

    static int minCost = Integer.MAX_VALUE;
    static int[] bestPath = new int[n + 1];

    static class Node {
        int[] path;
        boolean[] visited;
        int level, current, cost;

        Node(int[] p, boolean[] v, int l, int c, int co) {
            path = p;
            visited = v;
            level = l;
            current = c;
            cost = co;
        }
    }

    static void tsp() {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.cost, b.cost)
        );

        int[] path = new int[n + 1];
        boolean[] visited = new boolean[n];

        path[0] = 0;
        visited[0] = true;

        pq.add(new Node(path, visited, 1, 0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost >= minCost)
                continue;

            if (node.level == n) {
                int total = node.cost + cost[node.current][0];

                if (total < minCost) {
                    minCost = total;
                    bestPath = Arrays.copyOf(node.path, n + 1);
                    bestPath[n] = 0;
                }
                continue;
            }

            for (int i = 0; i < n; i++) {
                if (!node.visited[i]) {
                    int newCost = node.cost + cost[node.current][i];

                    if (newCost < minCost) {
                        int[] newPath = Arrays.copyOf(node.path, n + 1);
                        boolean[] newVisited =
                            Arrays.copyOf(node.visited, n);

                        newPath[node.level] = i;
                        newVisited[i] = true;

                        pq.add(new Node(newPath, newVisited,
                            node.level + 1, i, newCost));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        tsp();

        System.out.println("Minimum Cost: " + minCost);
        System.out.print("Best Path: ");

        for (int i = 0; i <= n; i++)
            System.out.print((bestPath[i] + 1) + " ");
    }
}