import java.util.ArrayList;
import java.util.Stack;

public class topologicalSortDfs {

    // Edge class to store destination vertex
    static class Edge {
        int destination;

        Edge(int destination) {
            this.destination = destination;
        }
    }

    // DFS function
    public static void dfs(ArrayList<ArrayList<Edge>> graph,
                           int current,
                           boolean[] visited,
                           Stack<Integer> stack) {

        // Mark current node as visited
        visited[current] = true;

        // Visit all unvisited neighbours
        for (Edge edge : graph.get(current)) {

            if (!visited[edge.destination]) {
                dfs(graph, edge.destination, visited, stack);
            }
        }

        /*
         * Push the current node only after
         * all its neighbours are completely explored.
         * This is the key idea behind Topological Sort.
         */
        stack.push(current);
    }

    // Topological Sort using DFS
    public static void topologicalSort(ArrayList<ArrayList<Edge>> graph, int V) {

        // Keeps track of visited vertices
        boolean[] visited = new boolean[V];

        // Stores vertices in reverse topological order
        Stack<Integer> stack = new Stack<>();

        // Run DFS for every unvisited vertex
        // Handles disconnected DAGs as well
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }

        // Pop stack to get the correct topological order
        System.out.println("Topological Order:");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {

        int V = 6;

        // Create adjacency list
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed Acyclic Graph (DAG)
        graph.get(5).add(new Edge(2));
        graph.get(5).add(new Edge(0));

        graph.get(4).add(new Edge(0));
        graph.get(4).add(new Edge(1));

        graph.get(2).add(new Edge(3));

        graph.get(3).add(new Edge(1));

        // Perform Topological Sort
        topologicalSort(graph, V);
    }
}