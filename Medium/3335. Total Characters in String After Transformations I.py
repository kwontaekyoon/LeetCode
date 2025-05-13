from collections import Counter, deque


class Deque:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        freq = [0] * 26
        for c in s:
            freq[ord(c) - ord('a')] += 1
        queue = deque(freq)
        for _ in range(t):
            queue.appendleft(queue.pop())
            queue[1] += queue[0]
        return sum(queue) % (10 ** 9 + 7)

class HashTable:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        # in 26 turns
        # a -> ab
        # b -> bc
        # ...
        # y -> yz
        # z -> zab
        MOD = 10 ** 9 + 7
        freqs = Counter(s)
        while t >= 26:
            new_freqs = Counter()
            for k, v in freqs.items():
                if k == 'z':
                    new_freqs['z'] += v
                    new_freqs['a'] += v
                    new_freqs['b'] += v
                else:
                    new_freqs[k] += v
                    new_freqs[chr(ord(k) + 1)] += v
            freqs = new_freqs
            t -= 26
        for _ in range(t):
            new_freqs = Counter()
            for k, v in freqs.items():
                if k == 'z':
                    new_freqs['a'] += v
                    new_freqs['b'] += v
                else:
                    new_freqs[chr(ord(k) + 1)] += v
            freqs = new_freqs
        return sum(freqs.values()) % MOD
