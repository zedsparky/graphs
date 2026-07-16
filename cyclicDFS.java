import java.util.ArrayList;
public class cyclicDFS {
    static boolean cyclic(ArrayList<ArrayList<Integer>> graph, int current, boolean[] visited,int parent) {
       
        visited[current] = true;
        for (int neighbour : graph.get(current)) {
            if (!visited[neighbour]) {
              if( cyclic(graph, neighbour, visited, current)){
                return true;
              }
              
            }else if (neighbour!=parent) {
                return true;
            }
        }return false;
    }

    public static void main(String[] args) {
        int b = 7;
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

        System.out.println("dfs traversal");
        boolean[] visited = new boolean[b];
        System.out.println("Cycle Present: " + cyclic(graph3, 0, visited, -1));
    }

}

