from typing import List


class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        vowels = set(['a', 'e', 'i', 'o', 'u'])
        prefix_sum = [0]
        for word in words:
            prefix_sum.append(prefix_sum[-1] + (1 if word[0] in vowels and word[-1] in vowels else 0))
        return [prefix_sum[r + 1] - prefix_sum[l] for l, r in queries]