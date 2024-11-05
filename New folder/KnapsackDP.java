import java.util.Scanner;

public class KnapsackDP {
    // Function to solve 0-1 Knapsack problem using dynamic programming
    public static int knapsack(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill dp array
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();
        
        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter weights and values for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight: ");
            weights[i] = scanner.nextInt();
            System.out.print("Item " + (i + 1) + " - Value: ");
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = scanner.nextInt();
        scanner.close();

        int maxProfit = knapsack(weights, values, capacity, n);
        System.out.println("Maximum profit in Knapsack = " + maxProfit);
    }
}


