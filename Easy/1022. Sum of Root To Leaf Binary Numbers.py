# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        stack = [(root, root.val)]
        sums = 0
        while stack:
            node, curr_sum = stack.pop()
            if not node.left and not node.right:
                sums += curr_sum
                continue
            if node.left:
                stack.append((node.left, curr_sum * 2 + node.left.val))
            if node.right:
                stack.append((node.right, curr_sum * 2 + node.right.val))
        return sums