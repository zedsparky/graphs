import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;


public class dijikstra {

static class Edge{
    int destination;
    int weight;
    Edge(int destination, int weight){
        this.destination=destination;
        this.weight=weight;
    }
}
static class pair{
    int node;
    int distance;
    pair(int node, int distance){
        this.node=node;
        this.distance=distance;
    }
}

public static int[] Dijikstra(ArrayList<ArrayList<Edge>> graph, int source, int v){
    int distance[]= new int[v];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[source]=0;
    PriorityQueue <pair> pq= new PriorityQueue<>((a,b)->a.distance-b.distance);
    pq.offer(new pair(source, 0));
    while (!pq.isEmpty()) {
        pair current=pq.poll();
        if (current.distance!=distance[current.node]) {
            continue;
        }
        for (Edge edge : graph.get(current.node)) {
            int newDistance=current.distance+edge.weight;
            if (newDistance<distance[edge.destination]) {
                distance[edge.destination]=newDistance;
               pq.offer(new pair(edge.destination, newDistance));
            }
        }
    }
    return distance;

}
public static void main(String[] args) {
    
        int V = 5;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed weighted graph
        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(4, 5));

        graph.get(1).add(new Edge(2, 1));

        graph.get(2).add(new Edge(3, 4));

        graph.get(4).add(new Edge(1, 3));
        graph.get(4).add(new Edge(2, 9));
        graph.get(4).add(new Edge(3, 2));

        int[] distance = Dijikstra(graph, 0, V);

        System.out.println("Shortest distances from source:");

        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + distance[i]);
        }
    
}
}
