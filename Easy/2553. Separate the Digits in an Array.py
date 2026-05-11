class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        result = []
        for num in nums:
            for c in str(num):
                result.append(int(c))
        return result
