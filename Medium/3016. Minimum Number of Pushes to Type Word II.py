class Solution:
    def minimumPushes(self, word: str) -> int:
        counter = Counter(word)
        sorted_freq = sorted([v for _, v in counter.items()], reverse = True)
        # print(sorted_freq)
        res = 0
        curr = 1
        left = 8
        for freq in sorted_freq:
            res += freq * curr
            left -= 1
            if not left:
                left = 8
                curr += 1
        return res
        

# wrong
class SolutionWrong:
    def minimumPushes(self, word: str) -> int:
        num_to_pushes = {}
        curr = 1
        left = 8
        min_pushes = 0
        for c in word:
            if c not in num_to_pushes:
                num_to_pushes[c] = curr
                left -= 1
                if left == 0:
                    left = 8
                    curr += 1
            min_pushes += num_to_pushes[c]
        return min_pushes
 