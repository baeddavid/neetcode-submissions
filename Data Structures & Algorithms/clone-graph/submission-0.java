class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(node);
        map.put(node, new Node(node.val));  // clone the entry node up front

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node neighbor : n.neighbors) {          // n.neighbors, not neighbors
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));  // first time seeing it → clone
                    queue.offer(neighbor);                      // only enqueue unseen nodes
                }
                map.get(n).neighbors.add(map.get(neighbor));    // wire clone-of-n → clone-of-neighbor
            }
        }

        return map.get(node);
    }
}