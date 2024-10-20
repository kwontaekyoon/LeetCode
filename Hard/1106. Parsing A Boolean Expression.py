from collections import deque


class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        stack = deque()
        for c in expression:
            if c == ',' or c == '(':
                continue
            if c in ["t", "f", "!", "&", "|"]:
                stack.append(c)
            else:
                has_true, has_false = False, False
                while stack[-1] not in ["!", "&", "|"]:
                    if stack.pop() == "t":
                        has_true = True
                    else:
                        has_false = True
                op = stack.pop()
                if op == "!":
                    stack.append("t" if not has_true else "f")
                elif op == "&":
                    stack.append("f" if has_false else "t")
                else:
                    stack.append("t" if has_true else "f")
        return stack[-1] == "t"