from typing import Counter, List


class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        def xsum(counter: Counter) -> int:
            return sum(x * y for x, y in sorted(counter.items(), key = lambda x: (-x[1], -x[0]))[:x])
        counter = Counter(nums[:k])
        result = [xsum(counter)]
        for i in range(k, len(nums)):
            counter[nums[i]] += 1
            counter[nums[i - k]] -= 1
            if counter[nums[i - k]] == 0:
                del counter[nums[i - k]]
            result.append(xsum(counter))
        return result