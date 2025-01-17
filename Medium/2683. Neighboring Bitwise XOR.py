from functools import reduce
from operator import xor
from typing import List


class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        return not reduce(xor, derived)
