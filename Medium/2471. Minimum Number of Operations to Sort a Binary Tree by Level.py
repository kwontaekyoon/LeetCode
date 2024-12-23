from collections import deque
from typing import Optional

import TreeNode


class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int: # type: ignore
        queue = deque([root])
        ans = 0
        while queue:
            a = []
            for _ in range(len(queue)):
                node = queue.popleft()
                a.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            n = len(a)
            a = sorted(range(n), key = lambda i: a[i])

            vis = [False] * n
            ans += n
            for v in a:
                if vis[v]:
                    continue
                while not vis[v]:
                    vis[v] = True
                    v = a[v]
                ans -= 1
        return ans