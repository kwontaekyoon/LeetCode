class Solution:
    def gcdValues(self, A: list[int], queries: list[int]) -> list[int]:
        mx = max(A)
        freq = [0] * (mx + 1)
        for a in A: 
            freq[a] += 1
            
        GCD = [0] * (mx + 1)
        
        for i in range(mx, 0, -1):
            sm = sum(freq[i::i])
            GCD[i] = sm * (sm - 1) // 2 - sum(GCD[i::i])
            
        GCD = list(accumulate(GCD))
        
        return [bisect.bisect_right(GCD, q) for q in queries]

class Solution1:
    def gcdValues(self, nums: List[int], queries: List[int]) -> List[int]:
        gcds = []
        n = len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                gcds.append(gcd(nums[i], nums[j]))
        gcds.sort()
        print(gcds)
        return [gcds[i] for i in queries]