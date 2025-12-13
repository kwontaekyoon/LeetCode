from typing import List


class Solution:
    def validateCoupons(self, codes: List[str], businessLine: List[str], isActive: List[bool]) -> List[str]:
        e, g, p, r = [], [], [], []
        for code, business, is_active in zip(codes, businessLine, isActive):
            if not code:
                continue
            is_code_valid = True
            for c in code:
                if not ('a' <= c <= 'z' or 'A' <= c <= 'Z' or '0' <= c <= '9' or c == '_'):
                    is_code_valid = False
                    break
            if not is_code_valid:
                continue
            if business not in {"electronics", "grocery", "pharmacy", "restaurant"}:
                continue
            if is_active:
                if business == "electronics":
                    e.append(code)
                elif business == 'grocery':
                    g.append(code)
                elif business == 'pharmacy':
                    p.append(code)
                else:
                    r.append(code)
        return sorted(e) + sorted(g) + sorted(p) + sorted(r)