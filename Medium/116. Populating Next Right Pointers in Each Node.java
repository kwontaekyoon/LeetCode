class Recursion {
    public Node connect(Node root) {
        var node = root;
        while (node != null) {
            var start = node;
            while (start != null) {
                if (start.left != null) {
                    start.left.next = start.right;
                }
                if (start.right != null && start.next != null) {
                    start.right.next = start.next.left;
                }
                start = start.next;
            }
            node = node.left;
        }
        return root;
    }
}

class UsingQueue {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        var queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size() - 1;
            var node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            for (int i = 0; i < size; i++) {
                node.next = queue.poll();
                node = node.next;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}