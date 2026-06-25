class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        n = len(nums)

        pre = [0] * (2 * n + 1)

        pre[n] = 1

        cnt = n
        presum = 0
        ans = 0

        for x in nums:
            if x == target:
                presum += pre[cnt]

                cnt += 1
                pre[cnt] += 1
            else:
                cnt -= 1

                presum -= pre[cnt]
                pre[cnt] += 1

            ans += presum

        return ans