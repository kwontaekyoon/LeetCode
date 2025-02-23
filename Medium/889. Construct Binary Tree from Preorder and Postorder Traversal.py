from typing import List, Optional
import TreeNode


class Stack:
    def constructFromPrePost(self, pre: List[int], post: List[int]):
        stack = [TreeNode(pre[0])]
        j = 0
        for v in pre[1:]:
            node = TreeNode(v)
            while stack[-1].val == post[j]:
                stack.pop()
                j += 1
            if not stack[-1].left:
                stack[-1].left = node
            else:
                stack[-1].right = node
            stack.append(node)
        return stack[0]

class Recursion:
    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]: # type: ignore
        def construct(l: int, h: int) -> TreeNode:
            if index[0] >= n or l > h:
                return None
            root = TreeNode(preorder[index[0]])
            index[0] += 1
            if l == h:
                return root
            i = l
            while i <= h and postorder[i] != preorder[index[0]]:
                i += 1
            if i <= h:
                root.left = construct(l, i)
                root.right = construct(i + 1, h - 1)
            return root
        n = len(preorder)
        index = [0]
        return construct(0, n - 1)