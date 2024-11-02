class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        prev = sentence[-1]
        for curr in sentence.split(" "):
            if curr[0] != prev:
                return False
            prev = curr[-1]
        return True