public class Codec {

    // ---- SERIALIZE (level-order) ----
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);    // enqueue children even if null
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // ---- DESERIALIZE (level-order) ----
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if(!vals[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(parent.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(parent.right);
            }
            i++;
        }
        return root;
    }
}