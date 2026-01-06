# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
from typing import Optional

from TreeNode import TreeNode


class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        # BFS ????
        curr_level = max_level = 1
        max_sum = root.val # type: ignore
        queue = deque([root])
        while queue:
            curr_size = len(queue)
            curr_sum = 0
            for _ in range(curr_size):
                curr_node = queue.popleft()
                curr_sum += curr_node.val # type: ignore
                if curr_node.left: # type: ignore
                    queue.append(curr_node.left) # type: ignore
                if curr_node.right: # type: ignore
                    queue.append(curr_node.right) # type: ignore
            if curr_sum > max_sum:
                max_sum = curr_sum
                max_level = curr_level
            curr_level += 1
        return max_level
