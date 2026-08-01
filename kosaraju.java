import java.util.ArrayList;
import java.util.Stack;

public class kosaraju {

    // Edge class
    static class Edge {
        int destination;

        Edge(int destination) {
            this.destination = destination;
        }
    }

    // ---------------------------------------------------
    // First DFS
    // Purpose: Store vertices according to finishing time
    // ---------------------------------------------------
    public static void dfs(ArrayList<ArrayList<Edge>> graph,
                           int current,
                           boolean[] visited,
                           Stack<Integer> stack) {

        // Mark current vertex as visited
        visited[current] = true;

        // Visit all neighbours
        for (Edge edge : graph.get(current)) {

            if (!visited[edge.destination]) {
                dfs(graph, edge.destination, visited, stack);
            }
        }

        /*
         * Push vertex into stack only after
         * exploring all of its neighbours.
         * This stores vertices in decreasing
         * finishing time.
         */
        stack.push(current);
    }

    // ---------------------------------------------------
    // Second DFS on Reversed Graph
    // Purpose: Print one Strongly Connected Component
    // ---------------------------------------------------
    public static void dfsReverse(ArrayList<ArrayList<Edge>> reverseGraph,
                                  int current,
                                  boolean[] visited) {

        // Mark current vertex as visited
        visited[current] = true;

        // Print current vertex
        System.out.print(current + " ");

        // Visit all neighbours
        for (Edge edge : reverseGraph.get(current)) {

            if (!visited[edge.destination]) {
                dfsReverse(reverseGraph, edge.destination, visited);
            }
        }
    }

    // ---------------------------------------------------
    // Kosaraju Algorithm
    // ---------------------------------------------------
    public static void kosarajuAlgo(ArrayList<ArrayList<Edge>> graph, int V) {

        // Stack stores vertices according to finishing time
        Stack<Integer> stack = new Stack<>();

        // Visited array
        boolean[] visited = new boolean[V];

        // -------------------------------
        // STEP 1
        // Perform DFS and fill the stack
        // -------------------------------
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }

        // -------------------------------
        // STEP 2
        // Reverse every edge in the graph
        // -------------------------------
        ArrayList<ArrayList<Edge>> reverseGraph = new ArrayList<>();

        // Create empty adjacency list
        for (int i = 0; i < V; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Reverse all edges
        for (int i = 0; i < V; i++) {

            for (Edge edge : graph.get(i)) {

                /*
                 * Original:
                 * i ----> destination
                 *
                 * Reverse:
                 * destination ----> i
                 */
                reverseGraph.get(edge.destination).add(new Edge(i));
            }
        }

        // -------------------------------
        // STEP 3
        // Reset visited array
        // -------------------------------
        visited = new boolean[V];

        System.out.println("Strongly Connected Components:");

        // -------------------------------
        // STEP 4
        // DFS on reversed graph
        // -------------------------------
        while (!stack.isEmpty()) {

            int current = stack.pop();

            if (!visited[current]) {

                /*
                 * One DFS call prints
                 * one Strongly Connected Component
                 */
                dfsReverse(reverseGraph, current, visited);

                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;

        // Create adjacency list
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        /*
              Graph

              0 → 2
              ↑   ↓
              |   1

              1 → 0

              0 → 3 → 4
         */

        graph.get(0).add(new Edge(2));

        graph.get(1).add(new Edge(0));

        graph.get(2).add(new Edge(1));
        graph.get(0).add(new Edge(3));

        graph.get(3).add(new Edge(4));

        // Find SCCs
        kosarajuAlgo(graph, V);
    }
}