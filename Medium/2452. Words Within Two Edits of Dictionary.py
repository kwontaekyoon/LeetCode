class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        def valid(word1: str, word2: str) -> bool:
            diff = 0
            for x, y in zip(word1, word2):
                if x != y:
                    if diff == 2:
                        return False
                    diff += 1
            return True
            
        result = []
        for query in queries:
            for word in dictionary:
                if valid(query, word):
                    result.append(query)
                    break
        return result
