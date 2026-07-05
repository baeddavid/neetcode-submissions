class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int done = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            done++;
            for(int next : adj.get(course)) {
                if(--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return done == numCourses;
    }
}
 