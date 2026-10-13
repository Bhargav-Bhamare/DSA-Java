package PracPractice;


public class Assign4_2 {
    public static void main(String[] args) {
        int[] deadline = {2, 1, 2, 1, 3};
        int[] profit   = {100, 19, 27, 25, 15};
        int n = profit.length;

        // Sort jobs by profit (descending)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (profit[i] < profit[j]) {
                    int t = profit[i];
                    profit[i] = profit[j];
                    profit[j] = t;

                    t = deadline[i];
                    deadline[i] = deadline[j];
                    deadline[j] = t;
                }
            }
        }

        int[] slot = new int[4];
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = deadline[i]; j > 0; j--) {
                if (slot[j] == 0) {
                    slot[j] = i + 1;
                    total += profit[i];
                    break;
                }
            }
        }

        System.out.println("Selected Jobs:");
        for (int i = 1; i < slot.length; i++)
            if (slot[i] != 0)
                System.out.print("J" + slot[i] + " ");

        System.out.println("\nMaximum Profit: " + total);
    }
}
