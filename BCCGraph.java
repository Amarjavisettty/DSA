import java.util.*;
public class BCCGraph {
    private int V;  
    private List<List<Integer>> adjList;  
    public BCCGraph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    private void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent, Stack<Integer> stack) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;
        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                stack.push(u);
                stack.push(v);
                dfs(v, visited, disc, low, parent, stack);
                low[u] = Math.min(low[u], low[v]);
                if ((parent[u] == -1 && children > 1) || (parent[u] != -1 && low[v] >= disc[u])) {
                    System.out.print("Biconnected Component: ");
                    while (stack.peek() != u) {
                        System.out.print(stack.pop() + " ");
                    }
                    System.out.print(stack.pop() + " ");
                    System.out.println();
                }
                children++;
            } else if (v != parent[u] && disc[v] < disc[u]) {
                low[u] = Math.min(low[u], disc[v]);
                stack.push(u);
                stack.push(v);
            }
        }
    }
    public void findBCCs() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];  
        int[] low = new int[V];   
        int[] parent = new int[V]; 
        Stack<Integer> stack = new Stack<>(); 
        Arrays.fill(parent, -1);
        Arrays.fill(disc, -1);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, disc, low, parent, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print("Biconnected Component: ");
            System.out.print(stack.pop() + " ");
            System.out.println();
        }
    }
    private static int time = 0;
    public static void main(String[] args) {
        BCCGraph graph = new BCCGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.findBCCs();
    }
}
