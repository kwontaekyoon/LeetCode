class Solution1:
    def smallestPalindrome(self, s: str) -> str:
        min_heap = []
        n = len(s)
        for i in range(n // 2):
            heapq.heappush(min_heap, s[i])
        # print(min_heap)
        res = ""
        while min_heap:
            res += heapq.heappop(min_heap)
        if n % 2:
            return res + s[n // 2] + res[::-1]
        return res + res[::-1]
            
            
class Solution:
    def smallestPalindrome(self, s: str) -> str:
        n = len(s)
        freq = Counter(s[:n // 2])
        
        half = "".join(c * freq[c] for c in ascii_lowercase)
        mid = s[n // 2] if n & 1 else ""
        
        return half + mid + half[::-1]