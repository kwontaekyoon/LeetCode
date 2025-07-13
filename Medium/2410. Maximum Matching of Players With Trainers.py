from typing import List


class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        trainers.sort()
        n, i = len(trainers), 0
        result = 0
        for ability in players:
            while i < n and trainers[i] < ability:
                i += 1
            if i == n:
                break
            result += 1
            i += 1
        return result
