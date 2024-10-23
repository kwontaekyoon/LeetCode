from collections import deque
from typing import Optional

from TreeNode import TreeNode


class Bfs:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root
        queue = deque([root])
        curr_level_sum = root.val
        while queue:
            next_level_sum = 0
            curr_level_len = len(queue)
            for _ in range(curr_level_len):
                curr_node = queue.popleft()
                curr_node.val = curr_level_sum - curr_node.val
                curr_children_sum = (curr_node.left.val if curr_node.left else 0) + \
                                    (curr_node.right.val if curr_node.right else 0)
                next_level_sum += curr_children_sum
                if curr_node.left:
                    curr_node.left.val = curr_children_sum
                    queue.append(curr_node.left)
                if curr_node.right:
                    curr_node.right.val = curr_children_sum
                    queue.append(curr_node.right)
            curr_level_sum = next_level_sum
        return root

class BfsAndHash:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        queue = deque([root])
        curr_cousins = {root: [root]}
        while queue:
            sum = 0
            next_cousins = {}
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                sum += curr.val
                if curr.left:
                    next_cousins.setdefault(curr, []).append(curr.left)
                    queue.append(curr.left)
                if curr.right:
                    next_cousins.setdefault(curr, []).append(curr.right)
                    queue.append(curr.right)
            for parent in curr_cousins.keys():
                curr_sum = 0
                for child in curr_cousins[parent]:
                    curr_sum += child.val
                for child in curr_cousins[parent]:
                    child.val = sum - curr_sum
            curr_cousins = next_cousins
        return root

