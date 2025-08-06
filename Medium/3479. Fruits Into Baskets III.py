class Solution():
    def numOfUnplacedFruits(self, fruits, baskets):
        n = len(fruits)
        seg = [0] * (4 * n + 1)
        def update(p):
            seg[p] = max(seg[p << 1], seg[p << 1 | 1])
        def build(p, l, r):
            if l == r:
                seg[p] = baskets[l]
                return
            mid = (l + r) >> 1
            build(p << 1, l, mid)
            build(p << 1 | 1, mid + 1, r)
            update(p)
        def assign(x, v, p, l, r):
            if x < l or x > r:
                return
            if l == r:
                seg[p] = v
                return
            mid = (l + r) >> 1
            assign(x, v, p << 1, l, mid)
            assign(x, v, p << 1 | 1, mid + 1, r)
            update(p)
        def firstLarger(v, p, l, r):
            if seg[p] < v:
                return r + 1
            if l == r:
                return r
            mid = (l + r) >> 1
            lf = firstLarger(v, p << 1, l, mid)
            if lf <= mid:
                return lf
            return firstLarger(v, p << 1 | 1, mid + 1, r)
        build(1, 0, n - 1)
        res = 0
        for x in fruits:
            pos = firstLarger(x, 1, 0, n - 1)
            if pos == n:
                res += 1
            else:
                assign(pos, 0, 1, 0, n - 1)
        return res