class Solution:
    def numOfStrings(self, patterns: List[str], word: str) -> int:
        return sum(1 if s in word else 0 for s in patterns)
