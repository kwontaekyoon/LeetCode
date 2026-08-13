class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: list[int]) -> list[int]:
        n = len(s)
        
        # Segment Tree Node fields:
        # max_len, ll (left length), lr (right length), len, cl (char left), cr (char right)
        tree = [None] * (4 * n)
        
        def push_up(i):
            l_idx = 2 * i
            r_idx = 2 * i + 1
            l = tree[l_idx]
            r = tree[r_idx]
            
            cl = l[4]
            cr = r[5]
            length = l[3] + r[3]
            
            # Left repeating prefix length
            ll = l[1]
            if l[1] == l[3] and l[4] == r[4]:
                ll += r[1]
                
            # Right repeating suffix length
            lr = r[2]
            if r[2] == r[3] and r[5] == l[5]:
                lr += l[2]
                
            # Max repeating length within children or bridging them
            bridge = l[2] + r[1] if l[5] == r[4] else 0
            max_len = max(l[0], r[0], bridge)
            
            tree[i] = (max_len, ll, lr, length, cl, cr)

        def build(i, l, r):
            if l == r:
                c = s[l]
                tree[i] = (1, 1, 1, 1, c, c)
                return
            mid = (l + r) // 2
            build(2 * i, l, mid)
            build(2 * i + 1, mid + 1, r)
            push_up(i)

        def update(i, l, r, p, c):
            if l == r:
                tree[i] = (1, 1, 1, 1, c, c)
                return
            mid = (l + r) // 2
            if p <= mid:
                update(2 * i, l, mid, p, c)
            else:
                update(2 * i + 1, mid + 1, r, p, c)
            push_up(i)

        # Convert string to list for mutable updates if needed, 
        # though the segment tree handles the character state itself.
        build(1, 0, n - 1)
        
        ans = []
        for char, idx in zip(queryCharacters, queryIndices):
            update(1, 0, n - 1, idx, char)
            ans.append(tree[1][0])
            
        return ans
