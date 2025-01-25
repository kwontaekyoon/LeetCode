from collections import defaultdict
from typing import List


class Sorting:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        n = len(nums)
        sorted_enum = sorted((num, idx) for idx, num in enumerate(nums))
        
        new_positions = []
        curr_positions = []
        prev = float('-inf')
        
        for num, idx in sorted_enum:
            if num > prev + limit:
                new_positions += sorted(curr_positions)
                curr_positions = [idx]
            else:
                curr_positions.append(idx)
            prev = num
        
        new_positions += sorted(curr_positions)
        
        res = [0] * n
        for i, idx in enumerate(new_positions):
            res[idx] = sorted_enum[i][0]
        
        return res
            
# TLE BF DFS
class Solution1:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        graph = defaultdict(list)
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if -limit <= nums[i] - nums[j] <= limit:
                    graph[i].append(j)
                    graph[j].append(i)
        visited = set()
        res = [-1] * len(nums)
        for i in range(len(nums)):
            if i not in visited:
                stack = []
                vals = [nums[i]]
                idxs = [i]
                stack.append(i)
                visited.add(i)
                while stack:
                    curr_idx = stack.pop()
                    for next_idx in graph[curr_idx]:
                        if next_idx not in visited:
                            vals.append(nums[next_idx])
                            idxs.append(next_idx)
                            stack.append(next_idx)
                            visited.add(next_idx)
                idxs.sort()
                vals.sort()
                for i in range(len(idxs)):
                    res[idxs[i]] = vals[i]
        return res