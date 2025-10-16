class Solution1:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        offs = defaultdict(int)
        for num in nums:
            offs[((num % value) + value) % value] += 1
        cannot = 0
        while offs[cannot % value] > 0:
            offs[cannot % value] -= 1
            cannot += 1
        return cannot

        
class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        offs = [0] * value
        for num in nums:
            offs[((num % value) + value) % value] += 1
        cannot = 0
        while offs[cannot % value]:
            offs[cannot % value] -= 1
            cannot += 1
        return cannot