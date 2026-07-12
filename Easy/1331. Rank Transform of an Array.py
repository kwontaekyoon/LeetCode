class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        sorted_arr = sorted(arr)
        rank = 0
        curr = -float('inf')
        num_to_rank = {}
        for num in sorted_arr:
            if num > curr:
                rank += 1
                curr = num
            num_to_rank[num] = rank
        return [num_to_rank[num] for num in arr]
