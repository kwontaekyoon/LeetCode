class Solution:
    def kthCharacter(self, k: int) -> str:
        result = 'a'
        while len(result) < k:
            size = len(result)
            for i in range(size):
                result += chr(((ord(result[i]) - 97) % 26 + 1) + 97)
        return result[k - 1]