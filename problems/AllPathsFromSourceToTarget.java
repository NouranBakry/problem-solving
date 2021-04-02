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
