import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfss{
 static void bfsSearch(ArrayList<ArrayList<Integer>> graph,int v){
        Queue<Integer> queue=new LinkedList<>();
        boolean visited[]= new boolean[v];
        
        queue.offer(0);
        visited[0]=true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbour : graph.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
        }
    }
    public static void main(String[] args) {
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
        bfsSearch(graph3, b);
    }
}
