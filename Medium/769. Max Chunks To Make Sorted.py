from typing import List


class Greedy:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        # since the arr range is [0:n-1], we dont need it
        # sorted_arr = sorted(arr)
        cnt, max_val = 0, 0
        for i in range(len(arr)):
            max_val = max(max_val, arr[i])
            if max_val == i:
            # if max_val == sorted_arr[i]:
                cnt += 1
        return cnt

class Sorting:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        sorted_arr = sorted(arr)
        left = 0
        res = 0
        for right in range(len(arr)):
            if sorted_arr[left:right] == sorted(arr[left:right]):
                res += 1
                left = right
        return res
            