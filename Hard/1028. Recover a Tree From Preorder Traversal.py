import re
from typing import Optional
import TreeNode


class DFS:
    def recoverFromPreorder(self, s: str) -> Optional[TreeNode]: # type: ignore
        def dfs(parent: TreeNode, level: int) -> None:
            nonlocal i, l
            while i < n and level == l:
                num = 0
                while i < n and s[i].isdigit():
                    num = num * 10 + int(s[i])
                    i += 1
                node = TreeNode(num)
                if not parent.left:
                    parent.left = node
                else:
                    parent.right = node
                l = 0
                while i < n and s[i] == '-':
                    l += 1
                    i += 1
                dfs(node, level + 1)
        i, n, l = 0, len(s), 0
        node = TreeNode(-1)
        dfs(node, 0)
        return node.left
        
class Solution:
    def recoverFromPreorder(self, S: str) -> TreeNode:
        dash_map = {}
        dash_cnt = 0
        first_num = ""
        for ch in S:
            if ch == '-': break
            first_num += ch
        dash_map[0] = TreeNode(int(first_num))
        s = re.findall(r'(-+)(\d+)', S)
        for dash, num in s:
            dash_num = len(dash)
            num = int(num)
            n = TreeNode(num)
            fa = dash_map[dash_num - 1]
            if not fa.left:
                fa.left = n
            elif not fa.right:
                fa.right = n
            dash_map[dash_num] = n
        return dash_map[0]