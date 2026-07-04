class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] p : prerequisites) adj.get(p[0]).add(p[1]);   // p[0] → p[1] (prereq unlocks course)

    boolean[][] reach = new boolean[n][n];
    for (int i = 0; i < n; i++) bfs(i, adj, reach);           // reachability FROM each node

    List<Boolean> res = new ArrayList<>();
    for (int[] q : queries) res.add(reach[q[0]][q[1]]);
    return res;
}

private void bfs(int start, List<List<Integer>> adj, boolean[][] reach) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    while (!queue.isEmpty()) {
        int u = queue.poll();
        for (int v : adj.get(u)) {
            if (!reach[start][v]) {          // not yet known reachable from start
                reach[start][v] = true;      // mark v reachable from start
                queue.offer(v);
            }
        }
    }
}
}