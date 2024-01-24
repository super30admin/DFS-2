#Time Complexity : O(m*n)
#Space Complexity :O(m*n)
#Did this code successfully run on Leetcode : yes
#Method used : BFS

from ast import List
import collections


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        if not grid or not grid[0]:
            return 0
        vis = [[0] * n for _ in range(m)]
        count = 0
        for r in range(m):
            for c in range(n):
                if vis[r][c] == 0 and grid[r][c] == "1":
                    count += 1
                    self.bfs(r, c, vis, grid)
        return count
    
    def bfs(self, row, col, vis: List[List[int]], grid: List[List[str]]):
        m = len(grid)
        n = len(grid[0])

        vis[row][col] = 1
        q = collections.deque()
        q.append((row, col))

        dirc = [(0, -1), (0, 1), (-1, 0), (1, 0)]
        
        while q:
            row, col = q.popleft()

            for dr, dc in dirc:
                nrow = row + dr
                ncol = col + dc

                if 0 <= nrow < m and 0 <= ncol < n and grid[nrow][ncol] == "1" and vis[nrow][ncol] == 0:
                    vis[nrow][ncol] = 1
                    q.append((nrow, ncol))