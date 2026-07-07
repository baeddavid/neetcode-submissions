class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /*
        Ok kinda stupid idea

        DFS from every node
        Hasmap to store frequency of the depth as key: value as List of the parent nodes that led to this depth
        Could do a treemap poll first key as that is the smallest height 
        
        */

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int height = getHeight(i, adj, n);
            map.computeIfAbsent(height, x -> new ArrayList<>()).add(i);
        }

        int min = Collections.min(map.keySet());
        return map.get(min);
    }

    private int getHeight(int node, List<List<Integer>> adj, int n) {
        int height = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                List<Integer> neighbor = adj.get(curr);
                for(Integer nb : neighbor) {
                    if(!visited[nb]) {
                        visited[nb] = true;
                        queue.offer(nb);
                    }
                }
            }
            height++;
        }
        return height;
    }
}