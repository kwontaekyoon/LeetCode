from typing import List


class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        prefix, odd_cnt, even_cnt, res = 0, 0, 0, 0
        for num in arr:
            prefix += num
            if prefix % 2:
                odd_cnt += 1
                res += even_cnt + 1
            else:
                even_cnt += 1
                res += odd_cnt
        return res % 1000000007