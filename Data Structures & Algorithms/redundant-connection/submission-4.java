class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            int u = e[0], v = e[1];
            if(dfs(adj, u, v, new boolean[n + 1])) return e;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }

    private boolean dfs(List<List<Integer>> adj, int cur, int target, boolean[] visited) {
        if(cur == target) return true;
        visited[cur] = true;
        for(int next : adj.get(cur)) {
            if(!visited[next] && 
                dfs(adj, next, target, visited)) {
                    return true;
                }
        }
        return false;
    }
}
