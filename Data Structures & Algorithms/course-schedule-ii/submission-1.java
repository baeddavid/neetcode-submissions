class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Adjacency list first
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        } 

        int[] indegree = new int[numCourses];
        int[] ordering = new int[numCourses];

        for(int[] pair : prerequisites) {
            int course = pair[0], prereq = pair[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int writeIdx = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            ordering[writeIdx++] = course;
            for(int next : adj.get(course)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        } 
        return writeIdx == numCourses ? ordering : new int[0];
    }
}
