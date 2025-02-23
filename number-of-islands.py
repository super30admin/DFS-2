# Time O(2m*n)
# Space O(m*n)
class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
        self.mat = None

    def numIslands(self, grid: List[List[str]]) -> int:
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0
        self.mat = grid
        for i in range(self.m):
            for j in range(self.n):
                if self.mat[i][j] == "1":
                    count += 1
                    self.dfs(i, j)

        return count

    def dfs(self, i: int, j: int) -> None:
        if i < 0 or i >= self.m or j < 0 or j >= self.n or self.mat[i][j] == "0": return

        self.mat[i][j] = "0"
        self.dfs(i+1, j)
        self.dfs(i-1, j)
        self.dfs(i, j+1)
        self.dfs(i, j-1)


# Time O(m*n)
# Space O(m*n)
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        count = 0
        dq = deque()
        directions = [(-1,0), (1,0), (0,1), (0,-1)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    dq.append((i, j))
                    while(len(dq) > 0):
                        (r, c) = dq.popleft()
                        for u, v in directions:
                            nr = r + u
                            nc = c + v
                            if -1 < nr < m and -1 < nc < n and grid[nr][nc] == "1":
                                grid[nr][nc] = "0"
                                dq.append((nr, nc))

        return count