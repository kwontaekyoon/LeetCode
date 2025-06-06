from collections import Counter


class Solution:
    def robotWithString(self, s: str) -> str:
        freqs = Counter(s)
        def min_char():
            for i in range(26):
                c = chr(ord('a') + i)
                if freqs[c] > 0:
                    return c
            return 'a'
        result, stack = [], []
        for c in s:
            stack.append(c)
            freqs[c] -= 1
            while stack and stack[-1] <= min_char():
                result.append(stack.pop())
        while stack:
            result.append(stack.pop())
        return ''.join(result)