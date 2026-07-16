import java.util.ArrayList;
import java.util.Stack;

public class topologicalSort {
    static void topSort(ArrayList<ArrayList<Integer>> graph, int current , boolean[]visited,Stack<Integer> stack){
        visited[current]=true;
        for (int neighbour : graph.get(current)) {
            if (!visited[neighbour]) {
                topSort(graph, neighbour, visited, stack);
            }
        }
        stack.push(current);
       
    }
    public static void main(String[] args) {
          int V = 6;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        /*
                 5 -----> 2 -----> 3 -----> 1
                 |                    ^
                 |                    |
                 -------> 0 ----------
                 |
                 -------> 4

        Directed Acyclic Graph (DAG)
        */

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(5).add(4);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(2).add(3);

        graph.get(3).add(1);

        boolean[] visited = new boolean[V];
        Stack<Integer> stack= new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSort(graph, i, visited, stack);
            }
        }
          System.out.println("Topological Order:");

        while (!stack.isEmpty()) {

            System.out.print(stack.pop() + " ");

        }
    
    }
}
