class Solution:
    def countAndSay(self, n: int) -> str:
        result = '1'
        for _ in range(n - 1):
            RLE = []
            prev = result[0]
            count = 1
            for i in range(1, len(result)):
                if result[i] == prev:
                    count += 1
                else:
                    RLE.append(str(count))
                    RLE.append(prev)
                    prev = result[i]
                    count = 1
            RLE.append(str(count))
            RLE.append(prev)
            result = ''.join(RLE)
        return result