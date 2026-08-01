import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class kahnAlgorithm {
    static class Edge{
        int destination;
        Edge(int destination){
            this.destination=destination;
        }
    }
    public static void topologicalSort(ArrayList<ArrayList<Edge>> graph, int v){
        int[] indegre= new int[v];// Stores indegree of every vertex

        //calaculate indgree of each vertec
        for (int i = 0; i < v; i++) {
            for (Edge edge : graph.get(i)) {
                indegre[edge.destination]++;
            }
        }
        //creating queue to store indegree 0
        Queue<Integer> queue= new LinkedList<>();

        for (int i = 0; i < v; i++) {
        if (indegre[i]==0) {
            queue.offer(i);
        }            
        }
        System.out.print("topological sort = ");

        //bfs
        while (!queue.isEmpty()) {
            //remove current
            int current = queue.poll();
            //print current vertex
            System.out.print(current + " ");
            //visit all neighbours 
            for (Edge edge : graph.get(current)) {
                indegre[edge.destination]--;
                if (indegre[edge.destination]==0) {
                    queue.offer(edge.destination);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<ArrayList<Edge>> graph= new ArrayList<>();
        //create adjacency list
        for (int i = 0; i <v; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(5).add(new Edge(2));
        graph.get(5).add(new Edge(0));

        graph.get(4).add(new Edge(0));
        graph.get(4).add(new Edge(1));

        graph.get(2).add(new Edge(3));

        graph.get(3).add(new Edge(1));

        //topological sorting
        topologicalSort(graph, v);

    }
}
