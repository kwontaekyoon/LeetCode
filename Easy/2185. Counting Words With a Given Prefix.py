from typing import List


class BF:
    def prefixCount(self, words: List[str], pref: str) -> int:
        return sum(word.startswith(pref) for word in words)

class Node:
    def __init__(self) -> None:
        self.dicto = {}
        self.startc = 0

class Trie:
    def __init__(self) -> None:
        self.head = Node()

    # Method to insert a word into the Trie
    def add(self, word: str) -> None:
        curr = self.head
        for char in word:
            if char not in curr.dicto:
                curr.dicto[char] = Node()
            curr = curr.dicto[char]
            curr.startc += 1

    # Method to count how many words start with the given prefix
    def startsWith(self, prefix: str) -> int:
        curr = self.head
        for char in prefix:
            if char not in curr.dicto:
                return 0
            curr = curr.dicto[char]
        return curr.startc

class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        # Create a Trie and insert all words into it
        trie = Trie()
        for word in words:
            trie.add(word)
        
        # Use the Trie to find how many words start with the prefix
        return trie.startsWith(pref)