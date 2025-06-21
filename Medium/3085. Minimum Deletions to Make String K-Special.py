from collections import Counter


class SortingCounting:
    def minimumDeletions(self, word: str, k: int) -> int:
        n = len(word)
        sorted_freqs = sorted(Counter(word).values())
        m = len(sorted_freqs)
        result = n
        for i, freq in enumerate(sorted_freqs):
            limit = freq + k
            size = 0
            for j in range(i, m):
                size += min(sorted_freqs[j], limit)
            result = min(result, n - size)
        return result
