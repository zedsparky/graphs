import java.util.ArrayList;
import java.util.PriorityQueue;

public class primsAlgorithm {
static class Pair{
    int node;
    int distance;

    Pair(int node, int distance){
        this.node= node;
        this.distance=distance;
    }
}
static class Edge{
    int destination;
    int weight;
    Edge(int destination, int weight){
        this.destination=destination;
        this.weight=weight;
    }
}
static int prims(ArrayList<ArrayList<Edge>> graph, int v ){
    boolean[]visited= new boolean[v];
    int cost=0;

    PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.distance-b.distance);
    pq.offer(new Pair(0, 0));

    while (!pq.isEmpty()) {
        Pair current= pq.poll();

        if (visited[current.node]) {
            continue;
        }
        visited[current.node]=true;
        cost+=current.distance;

        for (Edge edge : graph.get(current.node)) {
            if (!visited[edge.destination]) {
                pq.offer(new Pair(edge.destination, edge.weight));
            }
        }
    }
    return cost;

}
 public static void main(String[] args) {

        int v= 5;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected Graph
        graph.get(0).add(new Edge(1, 2));
        graph.get(1).add(new Edge(0, 2));

        graph.get(0).add(new Edge(3, 6));
        graph.get(3).add(new Edge(0, 6));

        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(1, 3));

        graph.get(1).add(new Edge(3, 8));
        graph.get(3).add(new Edge(1, 8));

        graph.get(1).add(new Edge(4, 5));
        graph.get(4).add(new Edge(1, 5));

        graph.get(2).add(new Edge(4, 7));
        graph.get(4).add(new Edge(2, 7));

        graph.get(3).add(new Edge(4, 9));
        graph.get(4).add(new Edge(3, 9));

        System.out.println("Minimum Spanning Tree Cost = " + prims(graph, v));
    }
}
