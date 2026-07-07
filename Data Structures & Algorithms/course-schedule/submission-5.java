class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int[] e : prerequisites) {
            adj.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            processed++;
            List<Integer> neighbors = adj.get(node);
            for(int n : neighbors) {
                if(--indegree[n] == 0)
                    queue.offer(n);
            }
        }
        return processed == numCourses;
    }
}
