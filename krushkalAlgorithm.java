import java.util.ArrayList;
import java.util.Collections;

public class krushkalAlgorithm {
       static int[] parent;
    static int[] rank;

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    public static void initialize(int V) {
        parent = new int[V];
        rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void unionByRank(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
    public static int krushkal(ArrayList<Edge> edges,int v){
        Collections.sort(edges);//sort the edges 
        int mstweight=0;//store MST total weight
       int edgeCount = 0;

        System.out.println("Edges in MST:");

        for (Edge edge : edges) {

            int rootSrc = find(edge.src);
            int rootDest = find(edge.dest);

            if (rootSrc != rootDest) {

                mstweight += edge.wt;

                System.out.println(edge.src + " - " + edge.dest + " : " + edge.wt);

                unionByRank(edge.src, edge.dest);

                edgeCount++;

                if (edgeCount == v - 1) {
                    break;
                }
            }
        }

        return mstweight;
    }

    public static void main(String[] args) {

        int V = 4;

        initialize(V);

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int mst = krushkal(edges, V);

        System.out.println("\nTotal MST Weight = " + mst);
    }
}