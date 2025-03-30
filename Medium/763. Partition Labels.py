from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        char_to_end = {c: i for i, c in enumerate(s)}
        result = []
        start = end = 0
        for i, c in enumerate(s):
            end = max(char_to_end[c], end)
            if i == end:
                result.append(end - start + 1)
                start = i + 1
        return result