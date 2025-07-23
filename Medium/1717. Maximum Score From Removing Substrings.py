class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        """
        Calculate the maximum score by removing substrings "ab" and "ba" from the input string.

        :param s: Input string
        :param x: Score for removing "ab"
        :param y: Score for removing "ba"
        :return: Maximum score achievable
        """
        a = b = max_points = 0
        for c in s:
            if c == 'b':
                if x >= y and a:
                    a -= 1
                    max_points += x
                else:
                    b += 1
            elif c == 'a':
                if y > x and b:
                    b -= 1
                    max_points += y
                else:
                    a += 1
            else:
                max_points += min(a, b) * (y if x >= y else x)
                a = b = 0
        return max_points + min(a, b) * (y if x >= y else x)