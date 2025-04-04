from typing import Optional


class Solution:
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]: # type: ignore
        def dfs(node: int, depth: int):
            if not node:
                return (None, depth)
            left_lca, left_depth = dfs(node.left, depth + 1)
            right_lca, right_depth = dfs(node.right, depth + 1)
            if left_depth > right_depth:
                return (left_lca, left_depth)
            elif right_depth > left_depth:
                return (right_lca, right_depth)
            else:
                return (node, left_depth)
        return dfs(root, 0)[0]