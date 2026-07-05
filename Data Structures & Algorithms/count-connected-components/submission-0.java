class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                queue.offer(i);
                count++;
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    visited.add(node);
                    List<Integer> neighbors = adj.get(node);
                    for(int j = 0; j < neighbors.size(); j++) {
                        if(!visited.contains(neighbors.get(j)))
                            queue.offer(neighbors.get(j));
                    }
                }
            }
        }
        return count;
    }
}
