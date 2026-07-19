class Solution:
    def smallestSubsequence(self, s: str) -> str:
        last = {v:i for i, v in enumerate(s)}
        stack = []
        in_stack = set()
        for i, v in enumerate(s):
            if v in in_stack:
                continue

            while stack and stack[-1] > v and last[stack[-1]] > i:
                in_stack.remove(stack.pop())

            stack.append(v)
            in_stack.add(v)

        return "".join(stack)