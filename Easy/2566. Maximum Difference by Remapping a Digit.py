class Solution:
    def minMaxDifference(self, num: int) -> int:
        s = str(num)
        replace_for_max = ''
        for c in s:
            if c != '9':
                replace_for_max = c
                break
        max_val = int(''.join('9' if c == replace_for_max else c for c in s))
        replace_for_min = s[0]
        min_val = int(''.join('0' if c == replace_for_min else c for c in s))
        return max_val - min_val