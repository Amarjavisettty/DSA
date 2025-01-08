import java.util.*;
class DFSAdjList {
 private int v;
 private LinkedList<Integer>[] adj;
 @SuppressWarnings("unchecked")
 public DFSAdjList(int v) {
 this.v = v;
 adj = new LinkedList[v];
 for (int i = 0; i < v; i++)
 adj[i] = new LinkedList<>();
 }
 public void addEdge(int src, int dest) {
 adj[src].add(dest);
 adj[dest].add(src); 
 }
 public void DFS(int start) {
 boolean[] visited = new boolean[v];
 Arrays.fill(visited, false);
 java.util.Stack<Integer> stack = new java.util.Stack<>();
 stack.push(start);
 visited[start] = true;
 while (!stack.isEmpty()) {
 int vis = stack.pop();
 System.out.print(vis + " ");
 
 for (int neighbor : adj[vis]) 
 if (!visited[neighbor]) {
 stack.push(neighbor);
 visited[neighbor] = true;
 }
 }
 }
 public static void main(String[] args) {

 }
}
