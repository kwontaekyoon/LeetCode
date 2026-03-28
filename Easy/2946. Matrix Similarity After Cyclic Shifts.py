class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        rows, cols = len(mat), len(mat[0])
        
        k %= cols  # (reduce k<n)
        
        for r in range(rows):
            for c in range(cols):
                if r % 2 == 0:
                    # even row, left shift
                    if mat[r][c] != mat[r][(c + k) % cols]:
                        return False
                else:
                    # odd row, right shift
                    if mat[r][c] != mat[r][(c - k) % cols]:
                        return False
        
        return True
