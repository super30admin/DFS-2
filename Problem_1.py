from typing import List
# BFS Solution
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0 or len(grid[0]) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        r = deque()
        c = deque()
        count = 0
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    r.append(i)
                    c.append(j)
                    while len(r) != 0:
                        cr = r.popleft()
                        cc = c.popleft()
                        for dir in dirs:
                            nr = cr + dir[0]
                            nc = cc + dir[1]
                            if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == "1":
                                r.append(nr)
                                c.append(nc)
                                grid[nr][nc] = "0"
        return count

# Time Complexity : O(m * n)
# Space Complexity : min(m, n)

# DFS Solution
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0 or len(grid[0]) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        self.dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    self.dfs(grid, i, j, m, n)
        return count
    
    def dfs(self, grid: List[List[str]], r: int, c: int, m: int, n: int) -> None:
        if r < 0 or c < 0 or r == m or c == n or grid[r][c] != "1":
            return
        grid[r][c] = "0"
        for dir in self.dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            self.dfs(grid, nr, nc, m, n)

# Time Complexity : O(m * n)
# Space Complexity : O(m * n)


