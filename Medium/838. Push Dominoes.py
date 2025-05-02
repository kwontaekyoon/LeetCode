class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        s = 'L' + dominoes + 'R'
        result = ''
        prev = 0
        for curr in range(1, len(s)):
            if s[curr] == '.':
                continue
            span = curr - prev - 1
            if prev > 0:
                result += s[prev]
            if s[prev] == s[curr]:
                result += s[prev] * span
            elif s[prev] == 'L' and s[curr] == 'R':
                result += '.' * span
            else:
                result += 'R' * (span // 2) + '.' * (span % 2) + 'L' * (span // 2)
            prev = curr
        return result