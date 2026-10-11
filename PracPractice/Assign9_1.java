package PracPractice;


import java.util.*;

public class Assign9_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        boolean[] active = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            active[i] = true;
        }

        System.out.print("Enter failed process ID: ");
        int failed = sc.nextInt();
        active[failed] = false;

        System.out.print("Enter process ID starting election: ");
        int starter = sc.nextInt();

        System.out.println("Process " + starter + " starts election.");

        int leader = starter;

        for (int i = starter + 1; i <= n; i++) {
            if (active[i]) {
                System.out.println("Process " + starter +
                    " sends election message to Process " + i);
                System.out.println("Process " + i + " responds.");
                leader = i;
            }
        }

        System.out.println("Process " + leader + " becomes the coordinator.");

        for (int i = 1; i <= n; i++) {
            if (active[i]) {
                System.out.println("Coordinator message sent to Process " + i);
            }
        }

        sc.close();
    }
}
