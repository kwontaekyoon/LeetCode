from typing import List


class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        ors_set = set()
        prev_ors = set()
        for curr in arr:
            curr_ors = {curr | prev_or for prev_or in prev_ors}
            curr_ors.add(curr)
            ors_set |= curr_ors
            prev_ors = curr_ors
        return len(ors_set)
        
# O(N^2)
class BF:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        ors_set = set()
        for i in range(len(arr)):
            curr_or = 0
            for j in range(i, len(arr)):
                curr_or |= arr[j]
                if curr_or not in ors_set:
                    ors_set.add(curr_or)
        return len(ors_set)