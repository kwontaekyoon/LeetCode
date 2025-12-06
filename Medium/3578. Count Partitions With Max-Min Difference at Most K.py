from collections import deque
from typing import List


class Solution:
    def countPartitions(self, nums, k):
        n=len(nums)
        MOD=10**9+7

        sum=[0]*(n+2)
        sum[1]=1

        qMax=deque()  
        qMin=deque() 

        l=0
        cnt=0

        for r, x in enumerate(nums):

            # max queue 
            while qMax and qMax[-1]<x:
                qMax.pop()
            qMax.append(x)

            # min queue 
            while qMin and qMin[-1]>x:
                qMin.pop()
            qMin.append(x)

            # shrink window
            while qMax[0]-qMin[0]>k:
                y=nums[l]
                if qMax[0]==y:
                    qMax.popleft()
                if qMin[0]==y:
                    qMin.popleft()
                l+=1

            #  update cnt & sum[r+2]
            cnt=(sum[r+1]-sum[l])%MOD
            sum[r+2]=(sum[r+1]+cnt)%MOD

        return cnt
    

class Solution1TLE:
    def countPartitions(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dp = [1] + [0] * n
        for r in range(1, n + 1):
            max_val = min_val = nums[r - 1]
            for l in range(r, 0, -1):
                max_val = max(max_val, nums[l - 1])
                min_val = min(min_val, nums[l - 1])
                if max_val - min_val <= k:
                    dp[r] += dp[l - 1]
        return dp[-1] % 1000000007
