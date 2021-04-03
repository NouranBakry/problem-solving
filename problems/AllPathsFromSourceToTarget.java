/**
 * Time Complexity Space Complexity O(2^N) so There are 2^n possible paths; for
 * each edge we have two decisions to add to path list or not to add
 * 
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return null;
        }
        List<List<Integer>> allPaths = new ArrayList();
        List<Integer> path = new ArrayList();
        path.add(0);
        DFS(graph, 0, path, allPaths);
        return allPaths;
    }

    public void DFS(int[][] graph, int source, List<Integer> path, List<List<Integer>> allPaths) {
        if (source == graph.length - 1) {
            allPaths.add(new ArrayList<>(path));
            return;
        }
        for (int edge : graph[source]) {
            path.add(edge);
            DFS(graph, edge, path, allPaths);
            path.remove(path.size() - 1);
        }
    }
}

/** another solution using bfs queue */
/**
 * Time complexity = O(n^2 * 2 ^n) 
 * Space Complexity = O(2^n)
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return null;
        }
        List<List<Integer>> allPaths = new ArrayList();
        List<Integer> path = new ArrayList();
        path.add(0);
        Queue<List<Integer>> queue = new LinkedList();
        queue.add(path);
        int currentEdge = 0;
        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int node = path.get(path.size() - 1);
            if (node == graph.length - 1) {
                allPaths.add(new ArrayList(path));
            } else {
                queue.add(new ArrayList(graph[node].asList()));
            }
        }
        return allPaths;
    }
}