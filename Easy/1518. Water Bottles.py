class Solution:
    def numWaterBottles(self, bottles: int, exchange: int) -> int:
        empty = result = 0
        while bottles:
            result += bottles
            empty += bottles
            bottles = empty // exchange
            empty %= exchange
        return result