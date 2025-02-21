from typing import Optional

import TreeNode


class FindElementsDFS:

    def __init__(self, root: Optional[TreeNode]): # type: ignore
        def dfs(node: TreeNode, val: int) -> None:
            if not node:
                return
            self.nums.add(val)
            dfs(node.left, val * 2 + 1)
            dfs(node.right, val * 2 + 2)
        self.nums = set()
        dfs(root, 0)

    def find(self, target: int) -> bool:
        return target in self.nums
    
class FindElementsStack:

    def __init__(self, root: Optional[TreeNode]): # type: ignore
        self.nums = set()
        root.val = 0
        stack = [root]
        while stack:
            node = stack.pop()
            self.nums.add(node.val)
            if node.left:
                node.left.val = node.val * 2 + 1
                stack.append(node.left)
            if node.right:
                node.right.val = node.val * 2 + 2
                stack.append(node.right)

    def find(self, target: int) -> bool:
        return target in self.nums