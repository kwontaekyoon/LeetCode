from collections import deque
from typing import List, Optional

import TreeNode


class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]: # type: ignore
        if not root:
            return []
        queue = deque([root])
        largest_vals = []
        while queue:
            size = len(queue)
            curr_largest = -float("inf")
            for _ in range(size):
                curr_node = queue.popleft()
                curr_largest = max(curr_largest, curr_node.val)
                if curr_node.left:
                    queue.append(curr_node.left)
                if curr_node.right:
                    queue.append(curr_node.right)
            largest_vals.append(curr_largest)
        return largest_vals
