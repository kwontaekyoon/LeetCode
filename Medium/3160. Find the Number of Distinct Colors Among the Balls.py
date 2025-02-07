from typing import List


class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        balls_to_colour = {}
        colours_to_cnt = {}
        res = []
        for ball, colour in queries:
            if ball in balls_to_colour:
                if colours_to_cnt[balls_to_colour[ball]] == 1:
                    del colours_to_cnt[balls_to_colour[ball]]
                else:
                    colours_to_cnt[balls_to_colour[ball]] -= 1
            balls_to_colour[ball] = colour
            if colour in colours_to_cnt:
                colours_to_cnt[colour] += 1
            else:
                colours_to_cnt[colour] = 1
            res.append(len(colours_to_cnt))
        return res