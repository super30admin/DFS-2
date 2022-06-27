"""Approach:DFS
TC O(2mn)- drop const - O(mn) - 
    Because in worst case we go over matrix once (mn) time and if it has all the 1s, we need to make them all `0`s
    just 1 call to DFS would do that in m*n time.
SC O(mn) Recursive stack space.
"""
class Solution:
    dirs = [(1,0),(0,1),(-1,0),(0,-1)]
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0 or len(grid[0])  == 0: 
            return 0
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    self.dfs(grid, i, j)
        return count

    def dfs(self,grid, r, c):
        # base
        if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or grid[r][c] == "0":
            return
        
        # logic
        grid[r][c] = "0"
        for i,j in self.dirs:
            nr = r + i
            nc = c + j
            self.dfs(grid, nr, nc)


"""Approach: BFS

TC O(2mn) - drop const - O(mn)
SC O(min(m,n)) - because BFS goes diagonally, so in the queue at any time we have min of (m,n) nodes.
"""
from collections import deque
class Solution:
    dirs = [(1,0),(0,1),(-1,0),(0,-1)]
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0 or len(grid[0])  == 0: 
            return 0
        count = 0
        q = deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    q.append((i,j))
                    while q:
                        r, c = q.popleft()
                        if r >= 0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == "1":
                            grid[r][c] = "0"
                            for k,l in self.dirs:
                                nr = r + k
                                nc = c + l
                                q.append((nr,nc))

        return count
        
        
        