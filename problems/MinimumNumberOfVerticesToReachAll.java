class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] visited = new int[n];
        List<Integer> output = new ArrayList<>();
        edges.forEach((list) -> {
            visited[list.get(1)] = 1;
        });
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                output.add(i);
            }
        }
        return output;
    }
}