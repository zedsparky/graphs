public class floyWarshall {
    static final int INF = 1000000000;

    public static void floydwarshall(int[][] distance, int v) {
          for (int k = 0; k < v; k++) {
        for (int i = 0; i < v; i++) { 
            for (int j = 0; j < v; j++) {
            
                    if (distance[i][k] != INF && distance[k][j] != INF) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        for (int i = 0; i < v; i++) {
            if (distance[i][i]<0) {
                System.out.println("Negative Weight Cycle Detected");
                return;
            }
        }
          System.out.println("Shortest Distance Matrix:");

        for (int i = 0; i < v; i++) {

            for (int j = 0; j < v; j++) {

                if (distance[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int V = 4;

        int[][] graph = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };

        floydwarshall(graph, V);
    }
}
    
