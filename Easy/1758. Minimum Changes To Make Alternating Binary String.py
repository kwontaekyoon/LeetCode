class Solution:
    def minOperations(self, s: str) -> int:
        count = 0
        for i, c in enumerate(s):
            if i % 2:
                if c == '1':
                    count += 1
            else:
                if c == '0':
                    count += 1
        return min(count, len(s) - count)

class Solution1:
    def minOperations(self, s: str) -> int:
        start_with_zero = 0
        start_with_one = 0
        for i, c in enumerate(s):
            if i % 2:
                if c == '1':
                    start_with_zero += 1
                else:
                    start_with_one += 1
            else:
                if c == '0':
                    start_with_zero += 1
                else:
                    start_with_one += 1
        return min(start_with_zero, start_with_one)