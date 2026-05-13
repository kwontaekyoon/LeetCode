class Solution:
    def minMoves(self, nums: List[int], limit: int) -> int:
        n = len(nums)
        diff = [0] * (2 * limit + 2)
        for i in range(n // 2):
            a = nums[i]
            b = nums[-1 - i]
            total = a + b
            low = min(a, b)
            high = max(a, b) + limit
            # all sum needs 2 moves
            diff[2] += 2
            diff[2 * limit + 1] -= 2
            # one move range
            diff[low + 1] -= 1
            diff[high + 1] += 1
            # 0 move
            diff[total] -= 1
            diff[total + 1] += 1
        # print(diff)
        min_moves = n
        moves = 0
        for target in range(2, 2 * limit + 1):
            moves += diff[target]
            min_moves = min(moves, min_moves)
        return min_moves
