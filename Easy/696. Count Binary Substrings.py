class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        prev_bit = s[0]
        streak = 1
        groups = []
        for curr_bit in s[1:]:
            if curr_bit == prev_bit:
                streak += 1
            else:
                groups.append(streak)
                prev_bit = curr_bit
                streak = 1
        groups.append(streak)
        res = 0
        for i in range(1, len(groups)):
            res += min(groups[i - 1], groups[i])
        return res
