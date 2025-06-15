class Solution:
    def maxDiff(self, num: int) -> int:
        s = str(num)
        max_str = ''
        for c in s:
            if c != '9':
                max_str = s.replace(c, '9')
                break
        if not max_str:
            max_str = s
        
        min_str = ''
        if s[0] != '1':
            min_str = s.replace(s[0], '1')
        else:
            for c in s[1:]:
                if c != '0' and c != '1':
                    min_str = s.replace(c, '0')
                    break
            if not min_str:
                min_str = s
                
        return int(max_str) - int(min_str)