class Solution:
    def valid(self, word: str, broken: set) -> bool:
        for c in word:
            if c in broken:
                return False
        return True
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        broken = set(brokenLetters)
        cnt_can_type = 0
        for word in text.split(" "):
            if self.valid(word, broken):
                cnt_can_type += 1
        return cnt_can_type