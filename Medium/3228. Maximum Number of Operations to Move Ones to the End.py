class Solution:
    def maxOperations(self, s: str) -> int:
        ones = 0
        ops = 0
        prev = None
        for curr in s:
            if curr == '1':
                if prev == '0':
                    ops += ones
                    prev = '1'
                ones += 1
            else:
                prev = '0'
        if s[-1] == '0':
            ops += ones
        return ops