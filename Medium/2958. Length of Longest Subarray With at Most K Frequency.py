class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        freq = defaultdict(int)
        res = l = 0
        for r in range(len(nums)):
            freq[nums[r]] += 1
            while freq[nums[r]] > k:
                freq[nums[l]] -= 1
                l += 1
            res = max(res, r - l + 1)
        return res


class Solution1:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        mapp = defaultdict(deque)
        res = l = 0
        for r in range(n):
            mapp[nums[r]].append(r)
            curr = mapp[nums[r]]
            if len(curr) > k:
                l = max(curr.popleft() + 1, l)
            res = max(r - l + 1, res)
        return res
