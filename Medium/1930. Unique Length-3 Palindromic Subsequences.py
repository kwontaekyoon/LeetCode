from collections import defaultdict


class OptimizedHashTable:
    def countPalindromicSubsequence(self, s: str) -> int:
        result = 0
        for c in set(s):
            l, r = s.find(c), s.rfind(c)
            result += len(set(s[l+1:r]))
        return result

class HashTable:
    def countPalindromicSubsequence(self, s: str) -> int:
        start_end = defaultdict(list)
        for i, c in enumerate(s):
            start_end[c].append(i)
        return sum(len(set(s[v[0]+1:v[-1]])) for v in start_end.values())

class PrefixSumAndBitManipulation:
    def countPalindromicSubsequence(self, s: str) -> int:
        prefix_bits = []
        bit = 0
        for c in s:
            prefix_bits.append(bit)
            bit |= (1 << (ord(c) - ord('a')))
        suffix_bits = []
        bit = 0
        for c in s[::-1]:
            suffix_bits.append(bit)
            bit |= (1 << (ord(c) - ord('a')))
        suffix_bits = suffix_bits[::-1]
        n = len(s)
        mid_to_bits = [0 for _ in range(26)]
        for i in range(1, n - 1):
            mid_to_bits[ord(s[i]) - ord('a')] |= (prefix_bits[i] & suffix_bits[i])
        return sum(bit.bit_count() for bit in mid_to_bits)