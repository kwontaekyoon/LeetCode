class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(node1: Optional[TreeNode], node2: Optional[TreeNode], level: int) -> None:
            if not node1 or not node2:
                return
            if level % 2 == 0:
                node1.val, node2.val = node2.val, node1.val
            dfs(node1.left, node2.right, level + 1)
            dfs(node1.right, node2.left, level + 1)
        dfs(root.left, root.right, 0)
        return root
