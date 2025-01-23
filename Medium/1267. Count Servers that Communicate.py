from typing import List


class Solution:
  def countServers(self, grid: List[List[int]]) -> int:
    count = 0
    for r in range(len(grid)):
      s = sum(grid[r])
      if s > 1:
        count += s
      elif s == 1:
        c = grid[r].index(1)
        if sum(grid[r][c] for r in range(len(grid))) > 1:
          count += 1
    return count

      

      
        