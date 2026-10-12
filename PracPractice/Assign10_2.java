package PracPractice;


import java.util.*;

public class Assign10_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of IoT devices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of clusters: ");
        int k = sc.nextInt();

        int[][] device = new int[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter x and y coordinates of device " + (i + 1) + ": ");
            device[i][0] = sc.nextInt();
            device[i][1] = sc.nextInt();
        }

        int[][] center = new int[k][2];

        // Select first k devices as initial cluster centers
        for (int i = 0; i < k; i++) {
            center[i][0] = device[i][0];
            center[i][1] = device[i][1];
        }

        int[] cluster = new int[n];

        for (int iteration = 0; iteration < 10; iteration++) {
            // Assign each device to nearest center
            for (int i = 0; i < n; i++) {
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < k; j++) {
                    int dx = device[i][0] - center[j][0];
                    int dy = device[i][1] - center[j][1];
                    int distance = dx * dx + dy * dy;

                    if (distance < min) {
                        min = distance;
                        cluster[i] = j;
                    }
                }
            }

            // Calculate new centers
            for (int j = 0; j < k; j++) {
                int x = 0, y = 0, count = 0;

                for (int i = 0; i < n; i++) {
                    if (cluster[i] == j) {
                        x += device[i][0];
                        y += device[i][1];
                        count++;
                    }
                }

                if (count > 0) {
                    center[j][0] = x / count;
                    center[j][1] = y / count;
                }
            }
        }

        System.out.println("\nIoT Device Clusters:");

        for (int j = 0; j < k; j++) {
            System.out.print("Cluster " + (j + 1) + ": ");

            for (int i = 0; i < n; i++) {
                if (cluster[i] == j) {
                    System.out.print("Device " + (i + 1) + " ");
                }
            }

            System.out.println();
        }

        sc.close();
    }
}