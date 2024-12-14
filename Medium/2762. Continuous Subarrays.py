from collections import defaultdict, deque
from typing import List


class SlidingWindowHashTable:
    def continuousSubarrays(self, nums: List[int]) -> int:
        N = len(nums)
        left, cnt = 0, 0
        map = defaultdict(int)
        def getCount(num: int) -> int:
            return map[num] + map[num - 1] + map[num - 2] + map[num + 1] + map[num + 2]
        for right in range(N):
            map[nums[right]] += 1
            while right - left + 1 > getCount(nums[right]):
                map[nums[left]] -= 1
                left += 1
            cnt += right - left + 1
        return cnt

class SlidingWindowMonotonicStack:
    def continuousSubarrays(self, nums: List[int]) -> int:
        l, res = 0, 0
        minD, maxD = deque(), deque()
        for r in range(len(nums)):
            while minD and nums[minD[-1]] >= nums[r]:
                minD.pop()
            while maxD and nums[maxD[-1]] <= nums[r]:
                maxD.pop()
            minD.append(r)
            maxD.append(r)
            while nums[maxD[0]] - nums[minD[0]] > 2:
                l += 1
                if minD[0] < l:
                    minD.popleft()
                if maxD[0] < l:
                    maxD.popleft()
            res += r - l + 1
        return res