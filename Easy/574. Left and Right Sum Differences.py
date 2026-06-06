class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        prefix = [0]
        for num in nums:
            prefix.append(prefix[-1] + num)
        suffix = [0]
        for num in nums[::-1]:
            suffix.append(suffix[-1] + num)
        suffix = suffix[::-1]
        return [abs(x - y) for x, y in zip(prefix[1:], suffix[:-1])]        
