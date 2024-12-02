class Solution:
    def isPrefixOfWord(self, sentence: str, search_word: str) -> int:
        for i, word in enumerate(sentence.split()):
            if word.startswith(search_word):
                return i + 1
        return -1