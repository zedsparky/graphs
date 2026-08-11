import java.util.ArrayList;
import java.util.Collections;

public class fractionalKnapsack {

    // Item class
    static class Item implements Comparable<Item> {

        int weight;
        int value;
        double ratio;


        Item(int weight, int value) {

            this.weight = weight;
            this.value = value;

            // Calculate value per unit weight
            this.ratio = (double) value / weight;
        }


        // Sort items in decreasing order of ratio
        @Override
        public int compareTo(Item item2) {

            return Double.compare(item2.ratio, this.ratio);
        }
    }


    // Fractional Knapsack Function
    public static double fractionalknapsack(ArrayList<Item> items, int capacity) {


        // Step 1:
        // Sort items according to value/weight ratio
        Collections.sort(items);


        double totalValue = 0;


        // Step 2:
        // Pick items greedily
        for (Item item : items) {


            // If complete item can fit
            if (item.weight <= capacity) {


                // Take complete item
                capacity -= item.weight;

                totalValue += item.value;


            }

            // If complete item cannot fit
            else {


                // Take only the remaining capacity
                totalValue += item.ratio * capacity;

                // Bag is full
                capacity = 0;

                break;
            }
        }


        return totalValue;
    }


    public static void main(String[] args) {


        ArrayList<Item> items = new ArrayList<>();

        /*
            Item   Weight   Value

             A       10       60
             B       20       100
             C       30       120
        */


        items.add(new Item(10, 60));
        items.add(new Item(20, 100));
        items.add(new Item(30, 120));


        int capacity = 50;


        double answer = fractionalknapsack(items, capacity);


        System.out.println("Maximum Value = " + answer);
    }
}