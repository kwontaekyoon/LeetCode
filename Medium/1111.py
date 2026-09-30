class Solution:
    def maxDepthAfterSplit(self, seq: str) -> list[int]:
        res = [0] * len(seq)
        depth = 0
        for i, c in enumerate(seq):
            if c == '(':
                depth += 1
                res[i] = depth % 2
            else:
                res[i] = depth % 2
                depth -= 1
        return res