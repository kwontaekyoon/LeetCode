from typing import List, Optional

from TreeNode import TreeNode


class DFS:
    def __init__(self):
        self.depth = [0] * 100001
        self.level_arr = [0] * 100001
        self.max1 = [0] * 100001
        self.max2 = [0] * 100001

    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        self.recursion(root, 0)
        res = []
        for q in queries:
            level = self.level_arr[q]
            res.append((self.max2[level] if self.max1[level] == self.depth[q] else self.max1[level]) + level - 1)
        return res

    def recursion(self, curr: Optional[TreeNode], level: int) -> int:
        if not curr:
            return 0

        # Set the level and calculate depth for the current node
        self.level_arr[curr.val] = level
        self.depth[curr.val] = 1 + max(self.recursion(curr.left, level + 1), self.recursion(curr.right, level + 1))

        # Update the highest and second-highest depths for the current level
        if self.max1[level] < self.depth[curr.val]:
            self.max2[level] = self.max1[level]
            self.max1[level] = self.depth[curr.val]
        elif self.max2[level] < self.depth[curr.val]:
            self.max2[level] = self.depth[curr.val]

        return self.depth[curr.val]

class BF_TLE:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        heights = []
        for querie in queries:
            heights.append(self.bfs(root, querie))
        return heights
    
    def bfs(self, root: Optional[TreeNode], remove: int) -> int:
        if root.val == remove:
            return 0
        max_height = 0
        queue = deque([root])
        while queue:
            curr_level = len(queue)
            for _ in range(curr_level):
                next_node = queue.popleft()
                if next_node.left and next_node.left.val != remove:
                    queue.append(next_node.left)
                if next_node.right and next_node.right.val != remove:
                    queue.append(next_node.right)
            if queue:
                max_height += 1
        return max_height