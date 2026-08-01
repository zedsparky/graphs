import java.util.ArrayList;

public class TarjanBridge {

    // Edge class
    static class Edge {
        int destination;

        Edge(int destination) {
            this.destination = destination;
        }
    }

    // Global timer
    static int time = 0;

    // ----------------------------------------------------
    // DFS Function
    // ----------------------------------------------------
    public static void dfs(ArrayList<ArrayList<Edge>> graph,
                           int current,
                           int parent,
                           boolean[] visited,
                           int[] discovery,
                           int[] low) {

        // Mark current vertex as visited
        visited[current] = true;

        // Assign discovery time
        discovery[current] = low[current] = time++;

        // Visit all neighbours
        for (Edge edge : graph.get(current)) {

            int neighbour = edge.destination;

            // Ignore the edge to parent
            if (neighbour == parent) {
                continue;
            }

            // Back Edge
            if (visited[neighbour]) {

                /*
                 * Update low value
                 * because neighbour was already visited
                 */
                low[current] = Math.min(low[current],
                                        discovery[neighbour]);
            }

            // Tree Edge
            else {

                dfs(graph,
                    neighbour,
                    current,
                    visited,
                    discovery,
                    low);

                /*
                 * Update low value using child's low value
                 */
                low[current] = Math.min(low[current],
                                        low[neighbour]);

                /*
                 * Bridge Condition
                 */
                if (low[neighbour] > discovery[current]) {

                    System.out.println(
                            current + " - " + neighbour +
                            " is a Bridge");
                }
            }
        }
    }

    // ----------------------------------------------------
    // Tarjan Algorithm
    // ----------------------------------------------------
    public static void tarjan(ArrayList<ArrayList<Edge>> graph,
                              int V) {

        boolean[] visited = new boolean[V];

        int[] discovery = new int[V];

        int[] low = new int[V];

        // DFS for every component
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                dfs(graph,
                    i,
                    -1,
                    visited,
                    discovery,
                    low);
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Edge>> graph =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        /*
              Graph

                 0
                / \
               1---2
                    |
                    |
                    3
                    |
                    4
        */

        graph.get(0).add(new Edge(1));
        graph.get(1).add(new Edge(0));

        graph.get(0).add(new Edge(2));
        graph.get(2).add(new Edge(0));

        graph.get(1).add(new Edge(2));
        graph.get(2).add(new Edge(1));

        graph.get(2).add(new Edge(3));
        graph.get(3).add(new Edge(2));

        graph.get(3).add(new Edge(4));
        graph.get(4).add(new Edge(3));

        tarjan(graph, V);
    }
}