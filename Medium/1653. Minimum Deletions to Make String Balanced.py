class Solution:
    def minimumDeletions(self, s: str) -> int:
        next_a = s.count('a')
        curr_b = 0
        min_del = min(next_a, len(s) - next_a)
        for c in s:
            if c == 'a':
                next_a -= 1
            else:
                curr_b += 1
            min_del = min(min_del, curr_b + next_a)
        return min_del