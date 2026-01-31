import bisect
from typing import List


class Bisect:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        i = bisect.bisect_right(letters, target)
        return letters[0] if i == len(letters) else letters[i]

class BruteForce:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        for letter in letters:
            if letter > target:
                return letter
        return letters[0]