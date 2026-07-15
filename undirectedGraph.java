import java.util.ArrayList;

public class undirectedGraph {
    public static void main(String[] args) {
        int v=4;
        System.out.println("pattern 1 solved ");
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        /*Practice Graph 1    
                 0
                / \
               1   2
               \   /
                 3  
                  */
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(1).add(3);
        graph.get(3).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        for (int i = 0; i < v; i++) {
              System.out.println(i + " -> " + graph.get(i));
        }
        System.out.println();


        /*
        0
      / | \
     1  2  3
     |     |
     4-----5
        */
        System.out.println("pattern 2 solved ");
        int a=6;
          ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            graph2.add(new ArrayList<>());
        }
        graph2.get(0).add(1);
        graph2.get(0).add(2);
        graph2.get(0).add(3);

        graph2.get(1).add(0);
        graph2.get(1).add(4);

        graph2.get(2).add(0);

        graph2.get(3).add(0);
        graph2.get(3).add(5);

        graph2.get(4).add(1);
        graph2.get(4).add(5);

        graph2.get(5).add(4);
        graph2.get(5).add(3);

        for (int i = 0; i < a; i++) {
            System.out.println(i + " -> " + graph2.get(i));
        }
        System.out.println();

       /*
          0
        / | \
       1  2  3
      / \ | /
     4---5
      \ /
       6
       */

         System.out.println("pattern 3 solved ");
        int b=7;
          ArrayList<ArrayList<Integer>> graph3 = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            graph3.add(new ArrayList<>());
        }
        graph3.get(0).add(1);
        graph3.get(0).add(2);
        graph3.get(0).add(3);

        graph3.get(1).add(0);
        graph3.get(1).add(4);
        graph3.get(1).add(5);

        graph3.get(2).add(0);
        graph3.get(2).add(5);

        graph3.get(3).add(0);
        graph3.get(3).add(5);

        graph3.get(4).add(1);
        graph3.get(4).add(5);
        graph3.get(4).add(6);

        graph3.get(5).add(1);
        graph3.get(5).add(2);
        graph3.get(5).add(3);
        graph3.get(5).add(4);
        graph3.get(5).add(6);

        graph3.get(6).add(4);
        graph3.get(6).add(5);

        for (int i = 0; i < b; i++) {
            System.out.println(i + " -> " + graph3.get(i));
        }
        System.out.println();
    }
}
