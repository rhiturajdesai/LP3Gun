import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class FractionalKnapsack {
    // Function to calculate the maximum value that can be obtained
    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                double ratio1 = (double) a.value / a.weight;
                double ratio2 = (double) b.value / b.weight;
                return Double.compare(ratio2, ratio1);
            }
        });

        double maxValue = 0.0;
        
        for (Item item : items) {
            if (capacity > 0 && item.weight <= capacity) {
                // If the item can fit, add it completely
                capacity -= item.weight;
                maxValue += item.value;
            } else {
                // Take fraction of the item if it cannot fit entirely
                if (capacity > 0) {
                    maxValue += (double) item.value * ((double) capacity / item.weight);
                }
                break; // No more capacity
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();

        Item[] items = new Item[n];
        
        System.out.println("Enter weight and value for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight: ");
            int weight = scanner.nextInt();
            System.out.print("Item " + (i + 1) + " - Value: ");
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = scanner.nextInt();
        scanner.close();

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
