from collections import Counter, deque
from typing import Optional

from TreeNode import TreeNode


class BFS:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        sums = []
        queue = deque([root])
        while queue:
            sum = 0
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                sum += curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            sums.append(sum)
        return -1 if len(sums) < k else sorted(sums)[-k]

class DFS:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        self.sum = Counter()
        self.travel(root, 0)
        return -1 if len(self.sum) < k else sorted(self.sum.values())[-k]
    def dfs(self, node: Optional[TreeNode], curr_level: int) -> None:
        if node == None:
            return
        self.sum[curr_level] += node.val
        self.travel(node.left, curr_level + 1)
        self.travel(node.right, curr_level + 1)