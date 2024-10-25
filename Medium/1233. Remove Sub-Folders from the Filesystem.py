from typing import List


class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        res = []
        prev = ''
        for path in sorted(folder):
            if not prev or not path.startswith(prev + '/'):
                res.append(path)
                prev = path
        return res