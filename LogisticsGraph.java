import java.util.*;

public class LogisticsGraph {

    static final int V = 5;

    // BFS Traversal
    static void BFS(List<Integer>[] graph, int start) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS Traversal
    static void DFS(List<Integer>[] graph, int node, boolean visited[]) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                DFS(graph, neighbor, visited);
            }
        }
    }

    // Prim's MST
    static void primMST(int[][] cost) {

        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {

            int min = Integer.MAX_VALUE;
            int u = -1;

            for (int v = 0; v < V; v++) {
                if (!mstSet[v] && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (cost[u][v] != 0 &&
                        !mstSet[v] &&
                        cost[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = cost[u][v];
                }
            }
        }

        int totalCost = 0;

        System.out.println("\nMinimum Spanning Tree:");

        for (int i = 1; i < V; i++) {
            System.out.println(
                    parent[i] + " - " + i +
                    " Cost: " + cost[i][parent[i]]);
            totalCost += cost[i][parent[i]];
        }

        System.out.println("Total MST Cost = " + totalCost);
    }

    public static void main(String[] args) {

        List<Integer>[] graph = new LinkedList[V];

        for (int i = 0; i < V; i++)
            graph[i] = new LinkedList<>();

        // Logistics routes
        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(0);
        graph[1].add(3);

        graph[2].add(0);
        graph[2].add(4);

        graph[3].add(1);
        graph[4].add(2);

        System.out.println("SMARTLOGIX TRANSPORT NETWORK");

        BFS(graph, 0);

        System.out.print("DFS Traversal: ");
        boolean visited[] = new boolean[V];
        DFS(graph, 0, visited);

        int[][] cost = {
                {0, 2, 3, 0, 0},
                {2, 0, 4, 5, 0},
                {3, 4, 0, 0, 6},
                {0, 5, 0, 0, 7},
                {0, 0, 6, 7, 0}
        };

        primMST(cost);
    }
}