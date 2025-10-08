class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        m = len(potions)
        potions.sort()
        result = []
        for spell in spells:
            min_req = success / spell
            result.append(m - bisect.bisect_left(potions, min_req))
        return result