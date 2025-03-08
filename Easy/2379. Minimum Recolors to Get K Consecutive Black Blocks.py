class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        cnt = 0
        for i in range(k):
            if blocks[i] == 'W':
                cnt += 1
        res = cnt
        for i in range(k, len(blocks)):
            if blocks[i] == 'W':
                cnt += 1
            if blocks[i - k] == 'W':
                cnt -= 1
            res = min(cnt, res)
        return res
