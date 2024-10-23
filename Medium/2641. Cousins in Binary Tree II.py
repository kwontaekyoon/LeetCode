from collections import deque
from typing import Optional

from TreeNode import TreeNode


class Bfs:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root

        queue = deque([root])
        curr_sum = root.val

        while queue:
            size = len(queue)
            next_sum = 0

            for _ in range(size):
                curr = queue.popleft()
                curr.val = curr_sum - curr.val
                sibling_sum = (curr.left.val if curr.left else 0) + (curr.right.val if curr.right else 0)
                if curr.left:
                    next_sum += curr.left.val
                    curr.left.val = sibling_sum
                    queue.append(curr.left)
                if curr.right:
                    next_sum += curr.right.val
                    curr.right.val = sibling_sum
                    queue.append(curr.right)

            curr_sum = next_sum
        
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

