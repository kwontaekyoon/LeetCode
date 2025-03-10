from collections import defaultdict


class SlidingWindow:
    def countOfSubstrings(self, word: str, k: int) -> int:
        res = 0
        vowels = set('aeiou')
        n = len(word)
        freq = defaultdict(int)
        lo, hi, cnt = 0, 0, 0
        for c in word:
            if c in vowels:
                freq[c] += 1
            else:
                cnt += 1
            while cnt > k:
                if word[hi] in vowels:
                    freq[word[hi]] -= 1
                    if freq[word[hi]] == 0:
                        del freq[word[hi]]
                else:
                    cnt -= 1
                hi += 1
                lo = hi
            while cnt == k and hi < n:
                if word[hi] in vowels and freq[word[hi]] > 1:
                    freq[word[hi]] -= 1
                    hi += 1
                else:
                    break
            if cnt == k and len(freq) == 5:
                res += hi - lo + 1
        return res

class Solution1:
    def countOfSubstrings(self, word: str, k: int) -> int:
        def atLeastK(k: int) -> int:
            a = e = i = o = u = c = l = res = 0    
            for r in range(n):
                if word[r] == 'a':
                    a += 1
                elif word[r] == 'e':
                    e += 1
                elif word[r] == 'i':
                    i += 1
                elif word[r] == 'o':
                    o += 1
                elif word[r] == 'u':
                    u += 1
                else:
                    c += 1
                while a and e and i and o and u and c >= k:
                    res += n - r
                    if word[l] == 'a':
                        a -= 1
                    elif word[l] == 'e':
                        e -= 1
                    elif word[l] == 'i':
                        i -= 1
                    elif word[l] == 'o':
                        o -= 1
                    elif word[l] == 'u':
                        u -= 1
                    else:
                        c -= 1
                    l += 1
            return res
        n = len(word)
        return atLeastK(k) - atLeastK(k + 1)