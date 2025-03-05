import java.util.*;
public class Knapsack {
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }
                else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
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
        System.out.print("Enter knapsack capacity: ");
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        System.out.println("Enter the values and weights of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " value: ");
            values[i] = scanner.nextInt();
            System.out.print("Item " + (i + 1) + " weight: ");
            weights[i] = scanner.nextInt();
        }
        scanner.close();
        int maxValue = knapsack(values, weights, capacity);
        System.out.println("Maximum value in knapsack: " + maxValue);
    }
}
output  
  Enter number of items: 4
Enter knapsack capacity: 5
Enter the values and weights of the items:
Item 1 value: 2
Item 1 weight: 5
Item 2 value: 6
Item 2 weight: 2
Item 3 value: 5
Item 3 weight: 1
Item 4 value: 5
Item 4 weight: 6
Maximum value in knapsack: 11
