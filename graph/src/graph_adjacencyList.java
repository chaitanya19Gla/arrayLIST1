import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class graph_adjacencyList {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 20));

        graph[1].add(new Edge(1, 3, 10));
        graph[1].add(new Edge(1, 0, 5));

        graph[2].add(new Edge(2, 4, 5));
        graph[2].add(new Edge(2, 0, 20));

        graph[3].add(new Edge(3, 1, 10));
        graph[3].add(new Edge(3, 5, 12));
        graph[3].add(new Edge(3, 4, 30));

        graph[4].add(new Edge(4, 5, 77));
        graph[4].add(new Edge(4, 3, 30));
        graph[4].add(new Edge(4, 2, 5));

        graph[5].add(new Edge(5, 4, 77));
        graph[5].add(new Edge(5, 3, 12));
        graph[5].add(new Edge(5, 6, 50));

        graph[6].add(new Edge(6, 5, 50));


    }
//    public static void BFS(ArrayList<Edge>[]graph){
//        Queue<Integer> q = new LinkedList<>();
//        boolean[] vis = new boolean[graph.length];
//        q.add(0);
//        while (!q.isEmpty()){
//            int curr = q.remove();
//            if (!vis[curr]){
//                System.out.print(curr + " ");
//                vis[curr] = true;
//                for (int i = 0 ; i<graph[curr].size() ; i++){
//                    Edge e = graph[curr].get(i);
//                    q.add(e.dest);
//                }
//            }
//        }
//
//    }
//    public static void dfs(ArrayList<Edge>[]graph , int curr,boolean vis[]){
//        System.out.print(curr + " ");
//        vis[curr] = true;
//        for (int i = 0  ; i<graph[curr].size() ; i++){
//            Edge e = graph[curr].get(i);
//            if (!vis[e.dest]){
//                dfs(graph , e.dest , vis);
//            }
//        }
//    }
//    static class Pair implements Comparable<Pair>{
//        int v;
//        int cost;
//
//    public Pair(int v, int cost) {
//        this.v = v;
//        this.cost = cost;
//    }
//
//    @Override
//    public int compareTo(Pair p2) {
//        return this.cost - p2.cost;
//    }
//}
//    public static void prims(ArrayList<Edge> graph[]){
//        boolean []vis = new boolean[graph.length];
//        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
//        pq.add(new Pair(0 , 0));
//        int finalCost = 0;
//        while (!pq.isEmpty()){
//            Pair curr = pq.remove();
//            if (!vis[curr.v]){
//                vis[curr.v] = true;
//                finalCost+=curr.cost;
//
//                for (int i = 0 ; i<graph[curr.v].size() ; i++){
//                    Edge e = graph[curr.v].get(i);
//                    pq.add(new Pair(e.dest , e.wt));
//                }
//            }
//        }
//        System.out.println("res = " + finalCost);
//    }
    public  static class Pair implements Comparable<Pair>{
        int node;
        int cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair p2) {
        return this.cost - p2.cost;
    }
}
public static void dijkstra(ArrayList<Edge>graph[] , int src , int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        for (int i = 0 ; i<V ; i++){
            if (i != src){
                dist[i] = Integer.MIN_VALUE;
            }
        }
        boolean []vis = new boolean[V];
        pq.add(new Pair(0,0));
        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if (!vis[curr.node]){
                vis[curr.node] = true;
                for (int i = 0 ; i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u]+e.wt<dist[v]){
                        dist[v] = dist[u]+e.wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for (int i = 0 ; i<V ; i++){
            System.out.print(dist[i]+ " ");
        }
    System.out.println( );
}

    public static void main(String[] args) {
        int Vertex = 7;
        ArrayList<Edge>[] graphs = new ArrayList[Vertex];
        createGraph(graphs);
        dijkstra(graphs , 0,Vertex);
        //prims(graphs);
        //BFS(graphs);
        //dfs(graphs , 0 , new boolean[Vertex]);

    }
}

