from collections import Counter, defaultdict
from typing import List


class Solution:
    def findLHS(self, nums: List[int]) -> int:
        counter = Counter(nums)
        result = 0
        for num in counter:
            if num + 1 in counter:
                result = max(result, counter[num] + counter[num + 1])
        return result
# O(N)
class Solution1:
    def findLHS(self, nums: List[int]) -> int:
        result = 0
        mpp = defaultdict(int)
        for num in nums:
            mpp[num] += 1
            if mpp[num - 1]:
                result = max(result, mpp[num - 1] + mpp[num])
            if mpp[num + 1]:
                result = max(result, mpp[num] + mpp[num + 1])
        return result 