class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        pair_xor = set()
        n = len(nums)
        for num1 in nums:
            for num2 in nums:
                pair_xor.add(num1 ^ num2)
        triplet_xor = set()
        for pair in pair_xor:
            for num in nums:
                triplet_xor.add(pair ^ num)
        return len(triplet_xor)

class Solution1:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        MAX_XOR = 2048

        pair_xor = [False] * MAX_XOR
        triplet_xor = [False] * MAX_XOR

        n = len(nums)

        for i in range(n):
            for j in range(i, n):
                pair_xor[nums[i] ^ nums[j]] = True

        for x in range(MAX_XOR):
            if not pair_xor[x]:
                continue

            for v in nums:
                triplet_xor[x ^ v] = True

        return sum(triplet_xor)
        