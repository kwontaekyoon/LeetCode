from itertools import combinations
from typing import List

class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        # These are the actual labels on the watch LEDs
        # We index them 0-3 for hours, and 4-9 for minutes
        leds = [
            (8, "h"), (4, "h"), (2, "h"), (1, "h"),      # Hour LEDs
            (32, "m"), (16, "m"), (8, "m"), (4, "m"), (2, "m"), (1, "m") # Min LEDs
        ]
        
        res = []
        
        # Select exactly 'turnedOn' number of LEDs from the 10 available
        for selection in combinations(leds, turnedOn):
            h_sum = 0
            m_sum = 0
            
            for value, unit in selection:
                if unit == "h":
                    h_sum += value
                else:
                    m_sum += value
            
            # Check if the selection makes a valid time
            if h_sum < 12 and m_sum < 60:
                res.append(f"{h_sum}:{m_sum:02d}")
        
        return res

class BitManipulation:
    def readBinaryWatch(self, k: int) -> List[str]:
        if k == 0:
            return ['0:00']
        mask = (1 << 6) - 1
        q = (1 << k) - 1
        limit = q << (10 - k)
        res = []
        while q <= limit:
            m = q & mask
            h = q >> 6
            if h < 12 and m < 60:
                res.append(f'{h}:{m:0>2}')
            r = q & -q
            n = q + r 
            q = (((q ^ n) // r) >> 2) | n
        return res
