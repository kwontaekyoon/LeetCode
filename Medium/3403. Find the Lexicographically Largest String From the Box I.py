class Solution:
    def answerString(self, word: str, num_friends: int) -> str:
        if num_friends == 1:
            return word
        n = len(word)
        result = ''
        length = n - num_friends + 1
        for i in range(n):
            result = max(word[i:i+length], result)
        return result