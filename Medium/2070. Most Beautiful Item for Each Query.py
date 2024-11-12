from typing import List


class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        max = float('inf')
        res = [[0, 0, max]]

        for price, beauty in sorted(items, key=lambda x: x[0]):
            last_bracket = res[-1]
            if beauty > last_bracket[1]:
                res[-1][2] = price
                res.append([price, beauty, max])

        ans = []

        for x in queries:
            for i in range(len(res) - 1, -1, -1):
                if res[i][0] <= x:
                    ans.append(res[i][1])
                    break

        return ans