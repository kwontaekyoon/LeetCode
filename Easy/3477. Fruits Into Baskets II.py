from typing import List


class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        fruits_not_fitting = len(fruits)
        for quantity in fruits:
            for idx, size in enumerate(baskets):
                if quantity <= size:
                    baskets[idx] = 0
                    fruits_not_fitting -= 1
                    break
        return fruits_not_fitting