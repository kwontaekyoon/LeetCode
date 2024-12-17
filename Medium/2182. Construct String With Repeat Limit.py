from collections import Counter


class Optimized:
    def repeatLimitedString(self, s: str, limit: int) -> str:
        chars = Counter(s)
        sorted_chars = sorted(chars.items(), reverse=True)
        res = []
        while sorted_chars:
            curr_char, curr_cnt = sorted_chars[0]
            if curr_cnt <= limit:
                res.append(curr_char * curr_cnt)
                sorted_chars.pop(0)
            else:
                res.append(curr_char * limit)
                sorted_chars[0] = (curr_char, curr_cnt - limit)
                if len(sorted_chars) < 2:
                    break
                next_char, next_cnt = sorted_chars[1]
                res.append(next_char)
                if next_cnt == 1:
                    sorted_chars.pop(1)
                else:
                    sorted_chars[1] = (next_char, next_cnt - 1)
        return ''.join(res)


class Sorting:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        chars = sorted(s, reverse=True)
        res = []
        cnt = 1
        ptr = 0
        for i in range(len(chars)):
            if res and res[-1] == chars[i]:
                if cnt < repeatLimit:
                    res.append(chars[i])
                    cnt += 1
                else:
                    ptr = max(ptr, i + 1)
                    while ptr < len(chars) and chars[ptr] == chars[i]:
                        ptr += 1
                    if ptr < len(chars):
                        res.append(chars[ptr])
                        chars[i], chars[ptr] = chars[ptr], chars[i]
                        cnt = 1
                    else:
                        break
            else:
                res.append(chars[i])
                cnt = 1
        return ''.join(res)