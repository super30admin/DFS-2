# Time complexity - O(m * n)
# Space complexity - O(min(m, n))

# Approach - dfs - A little bit different approach, need to maintain a visisted set, run a for loop first on
# the matrix, then everytime "1" is found, append the number of islands, run dfs on it, 
# add new locations in visited. Finally return the num of islands.

from typing import List
from queue import Queue
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        self.m = len(grid)
        self.n = len(grid[0])
        self.visited = set()
        self.dirs = [[0, -1], [0, 1], [1, 0], [-1, 0]]
        islands = 0

        for r in range(self.m):
            for c in range(self.n):
                if grid[r][c] == "1" and (r,c) not in self.visited:
                    islands += 1
                    self.dfs(grid, r, c)
        return islands
    
    def dfs(self, grid: List[List[str]], i: int, j: int) -> None:
        # base
        if i < 0 or i == self.m or j < 0 or j == self.n or grid[i][j] != "1" or (i, j) in self.visited:
            return

        # logic
        self.visited.add((i, j))
        for d in self.dirs:
            nr = i + d[0]
            nc = j + d[1]
            self.dfs(grid, nr, nc)