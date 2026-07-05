class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[numCourses];

        for(int[] e : prerequisites) {
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> adjNode = adj.get(node);

            for(int n : adjNode) {
                if(--indegree[n] == 0) queue.offer(n);
            }
        }

        for(int c : indegree) {
            if(c != 0) return false;
        }

        return true;
    }
}
