from typing import List


STONE = '#'
OBSTACLE = '*'

class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        for row in box:
            drop_pos = len(row) - 1  
            for curr_pos in range(len(row)-1, -1, -1):
                if row[curr_pos] == OBSTACLE:  
                    drop_pos = curr_pos - 1
                elif row[curr_pos] == STONE:  
                    row[drop_pos], row[curr_pos] = row[curr_pos], row[drop_pos]
                    drop_pos -= 1
        return zip(*box[::-1])