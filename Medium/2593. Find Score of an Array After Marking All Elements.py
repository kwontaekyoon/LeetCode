from collections import defaultdict, deque
from typing import List


class Sorting:
    def findScore(self, nums: List[int]) -> int:
        N = len(nums)
        score = 0
        marked = [False] * N
        for num, idx in sorted((num, idx) for idx, num in enumerate(nums)):
            if marked[idx]:
                continue
            score += num
            marked[idx] = True
            if idx > 0:
                marked[idx - 1] = True
            if idx < N - 1:
                marked[idx + 1] = True
        return score

class HashTableAndQueue:
    def findScore(self, nums: List[int]) -> int:
        map = defaultdict(deque)
        for i in range(len(nums)):
            map[nums[i]].append(i)
        mark = [False] * len(nums)
        mark_cnt = 0
        score = 0
        for num in sorted(nums):
            curr = map[num].popleft()
            if mark[curr]:
                continue
            score += num
            mark[curr] = True
            mark_cnt += 1
            if curr > 0 and not mark[curr - 1]:
                mark[curr - 1] = True
                mark_cnt += 1
            if curr < len(nums) - 1 and not mark[curr + 1]:
                mark[curr + 1] = True
                mark_cnt += 1
            if mark_cnt == len(nums):
                break
        return score
