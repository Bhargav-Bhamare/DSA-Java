package PracPractice;
import java.util.*;
public class Assign10_1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();

        int[] execution = new int[n];
        int[] deadline = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter execution time and deadline for Task " + (i + 1) + ":");
            execution[i] = sc.nextInt();
            deadline[i] = sc.nextInt();
        }

        // Sort tasks by earliest deadline
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (deadline[i] > deadline[j]) {
                    int temp = deadline[i];
                    deadline[i] = deadline[j];
                    deadline[j] = temp;

                    temp = execution[i];
                    execution[i] = execution[j];
                    execution[j] = temp;
                }
            }
        }

        int time = 0;

        System.out.println("\nEnergy-Efficient Task Schedule:");

        for (int i = 0; i < n; i++) {
            if (time + execution[i] <= deadline[i]) {
                System.out.println("Task " + (i + 1) +
                    " executes from " + time + " to " +
                    (time + execution[i]));

                time += execution[i];
            } else {
                System.out.println("Task " + (i + 1) +
                    " misses its deadline.");
            }
        }

        System.out.println("Total execution time: " + time);
        System.out.println("Processor can use idle time to enter low-power mode.");

        sc.close();
    }
}