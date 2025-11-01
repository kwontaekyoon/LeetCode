class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        result = prev = 0
        for curr in target:
            if curr > prev:
                result += curr - prev
            prev = curr
        return result