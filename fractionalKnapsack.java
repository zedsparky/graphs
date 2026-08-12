import java.util.ArrayList;
import java.util.Collections;

public class fractionalKnapsack {
    static class Item implements Comparable<Item>{
        int weight ;
        int value;
        double ratio;

        Item(int weight,int value){
            this.weight=weight;
            this.value=value;

            this.ratio=(double) value/weight;
        }
        //sorting items in decending order
        @Override
        public int compareTo(Item Item2){
            return Double.compare(Item2.ratio, this.ratio);
        }
    }
    //fractional knapsack function
    public static double fractional(ArrayList<Item> items, int capapcity){
        //sort
        Collections.sort(items);
        double totalValue=0;
        //pick value
        for (Item item : items) {
            if (item.weight<=capapcity) {
                //take complete item
                capapcity -= item.weight;
                totalValue += item.value;
            }
            else{
                //take only remainning capacptiy
                totalValue += item.ratio*capapcity;
                //bag full
                capapcity=0;
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

        double answer = fractional(items, capacity);

        System.out.println("Maximum Value = " + answer);
    }
}
