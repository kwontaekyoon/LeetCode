class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack = [[]]
        for c in s:
            if c == '(':
                stack.append([])
            elif c == ')':
                curr = stack.pop()
                curr.reverse()
                stack[-1].extend(curr)
            else:
                stack[-1].append(c)
        return "".join(stack[-1])
