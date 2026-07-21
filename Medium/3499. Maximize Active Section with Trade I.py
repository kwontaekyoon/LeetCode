class Solution:
    def maxActiveSectionsAfterTrade(self, s: str) -> int:
        ones = s.count('1')        
        prefix = []
        curr = 0
        for c in s:
            if c == '1':
                if curr:
                    prefix.append(curr)
                    curr = 0
            else:
                curr += 1
        if curr:
            prefix.append(curr)
        # print(prefix)
        maxx = 0
        for i in range(1, len(prefix)):
            maxx = max(prefix[i - 1] + prefix[i], maxx)
        return ones + maxx



class Solution1:
    def maxActiveSectionsAfterTrade(self, s: str) -> int:
        s = '1' + s + '1'
        prefix = [[1, 0]]
        prev = '1'
        for c in s:
            if c == prev:
                prefix[-1][1] += 1
            else:
                prev = c
                prefix.append([int(c), 1])
        max_active = 0
        n = len(prefix)
        for i, (active, count) in enumerate(prefix):
            # print (i, active, count)
            if active:
                if i == 0 or i == n - 1:
                    max_active = max(count - 1, max_active)
                else:
                    prev = prefix[i - 1][1]
                    next = prefix[i + 1][1]
                    prev_prev = 0
                    if i == 2:
                        prev_prev = prefix[i - 2][1] - 1
                    elif i > 2:
                        prev_prev = prefix[i - 2][1]
                    next_next = 0
                    if i == n - 3:
                        next_next = prefix[i + 2][1] - 1
                    elif i < n - 3:
                        next_next = prefix[i + 2][1]
                    # print(prev_prev, prev, next, next_next)
                    max_active = max(prev_prev + prev + count + next + next_next, max_active)
        return max_active