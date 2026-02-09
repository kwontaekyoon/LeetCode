# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional

from TreeNode import TreeNode


class Solution:
    def inorder(self, node: Optional[TreeNode], vals: List[int]) -> None:
        if not node:
            return
        self.inorder(node.left, vals)
        vals.append(node.val)
        self.inorder(node.right, vals)
    def build(self, vals: List[int], l: int, r: int) -> Optional[TreeNode]:
        if l > r:
            return None
        m = (l + r) // 2
        # node = TreeNode(vals[mid])
        # node.left = self.build(vals, l, mid - 1)
        # node.right = self.build(vals, mid + 1, r)
        # return node
        return TreeNode(vals[m], self.build(vals, l, m - 1), self.build(vals, m + 1, r))
    def balanceBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        vals = []
        self.inorder(root, vals)
        return self.build(vals, 0, len(vals) - 1)