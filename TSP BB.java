import java.util.Arrays;
public class TSPBranchBound {
   static final int INF = Integer.MAX_VALUE;
    static int getBound(int[] path, boolean[] visited, int[][] distMatrix) {
        int n = distMatrix.length;
        int cost = 0, minEdge = 0;
        for (int i = 0; i < path.length - 1; i++) {
            cost += distMatrix[path[i]][path[i + 1]];
        }
        boolean[] localVisited = Arrays.copyOf(visited, visited.length);
        for (int i = 0; i < path.length; i++) {
            localVisited[path[i]] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!localVisited[i]) {
                int min = INF;
                for (int j = 0; j < n; j++) {
                    if (i != j && !localVisited[j]) {
                        min = Math.min(min, distMatrix[i][j]);
                    }
                }
                minEdge += min;
            }
        }
        return cost + minEdge;
    }
 static void tspBranchBound(int[][] distMatrix) {
        int n = distMatrix.length;
        int[] bestPath = new int[n + 1];
        int bestCost = INF;
        boolean[] visited = new boolean[n];
        int[] path = new int[n + 1];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            path[0] = i;
            branchBound(i, 1, visited, path, 0, distMatrix, bestPath, bestCost);
            visited[i] = false;
        }
        System.out.println("Best path: " + Arrays.toString(bestPath));
        System.out.println("Best cost: " + bestCost);
    }
    static void branchBound(int currentCity, int pathLength, boolean[] visited, int[] path, 
                            int currentCost, int[][] distMatrix, int[] bestPath, int bestCost) {
        int n = distMatrix.length;
        if (pathLength == n) {
            currentCost += distMatrix[path[pathLength - 1]][path[0]];
            if (currentCost < bestCost) {
                bestCost = currentCost;
                System.arraycopy(path, 0, bestPath, 0, n);
                bestPath[n] = path[0];
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                path[pathLength] = i;
                visited[i] = true;

                int bound = getBound(path, visited, distMatrix);
                if (bound < bestCost) {
                    branchBound(i, pathLength + 1, visited, path, 
                                 currentCost + distMatrix[path[pathLength - 1]][path[pathLength]], 
                                 distMatrix, bestPath, bestCost);
                }

                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[][] distMatrix = {
            {0, 10, 15, 20, 25},
            {10, 0, 35, 25, 30},
            {15, 35, 0, 30, 5},
            {20, 25, 30, 0, 10},
            {25, 30, 5, 10, 0}
        };
        tspBranchBound(distMatrix);
    }
}
output 
  Best path: [4, 3, 2, 1, 0, 4]
Best cost: 2147483647
