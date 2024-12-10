from collections import defaultdict


class Optimized:
    def maximumLength(self, s: str) -> int:
        map = defaultdict(list)
        N = len(s)
        i = 0
        while i < N:
            tmp = 1
            ch = s[i]
            while i < N - 1 and s[i] == s[i+1]:
                tmp += 1
                i += 1
            map[ch].append(tmp)
            i += 1
            
        maxi = -1
        for ch, lis in map.items():
            lis.sort(reverse=True)
            if lis[0] >= 3:
                maxi = max(maxi, lis[0]-2)
            if len(lis) >= 2:
                if lis[0] >= 2:
                    maxi = max(maxi, min(lis[0]-1, lis[1]))
                if len(lis) >= 3:
                    maxi = max(maxi, lis[2])
                
        return maxi   

class HashTable:
    def maximumLength(self, s: str) -> int:
        count_substrings = defaultdict(int)
        N = len(s)
        l, r = 0, 0
        while r < N:
            while r < N and s[l] == s[r]:
                r += 1
            for i in range(1, r - l + 1):
                count_substrings[s[l] * i] += r - l - i + 1
            l = r
        res = -1
        for k, v in count_substrings.items():
            if v >= 3:
                res = max(res, len(k))
        return res