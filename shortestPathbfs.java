import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class shortestPathbfs {
    static void shortpath(ArrayList<ArrayList<Integer>> graph, int source) {
        int V = graph.size();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];

        Arrays.fill(distance, -1);

        queue.offer(source);
        visited[source] = true;
        distance[source] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour : graph.get(current)) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    distance[neighbour] = distance[current] + 1;
                    queue.offer(neighbour);
                }
            }
        }
        System.out.println("shortest distance from source "+ source);
        for (int i = 0; i < V; i++) {
        System.out.println(source + " -> " + i + " = " + distance[i]);
            
        }
    }
      public static void main(String[] args) {

        int V = 7;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected Graph
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(1).add(3);
        graph.get(3).add(1);

        graph.get(1).add(4);
        graph.get(4).add(1);

        graph.get(2).add(5);
        graph.get(5).add(2);

        graph.get(4).add(6);
        graph.get(6).add(4);

        shortpath(graph, 0);
    }
}
