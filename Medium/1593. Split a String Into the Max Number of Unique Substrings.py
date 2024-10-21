class Solution:
    def maxUniqueSplit(self, s: str) -> int:
        self.set = set()
        self.max = 0
        self.backtrack(s, 0)
        return self.max
    def backtrack(self, s: str, start: int) -> None:
        if self.max >= len(self.set) + len(s) - start:
            return
        if start == len(s):
            self.max = max(self.max, len(self.set))
            return
        for end in range(start + 1, len(s) + 1):
            if s[start:end] not in self.set:
                self.set.add(s[start:end])
                self.backtrack(s, end)
                self.set.remove(s[start:end])