# TC: O(mn)
# SC: O(mn)
# DFS
# Traverse through matrix, when u encounter a "1"- start dfs around that node. The motive of dfs is to check extent to which its neighbours have 1's. In order to not repeat the nodes, mark it as "0"(visited). Keep incrementing the counter as you find new "1"

class Solution:
    def numIslands(self, grid):
        totalIslands = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    totalIslands += 1
        return totalIslands
    
    def dfs(self, grid, sr, sc):
        # base
        if sr < 0 or sc < 0 or sr == len(grid) or sc == len(grid[0]) or grid[sr][sc] == '0':
            return
        # logic
        grid[sr][sc] = '0'
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        for d in dirs:
            r = d[0] + sr
            c = d[1] + sc
            self.dfs(grid, r, c)

# BFS
# TC: O(mn)
# SC: O(min(m,n))
# Here, we explore all neighbours of current node before evaluating child's neighbours. We maintain queue of "reached" node for "evaluation of neighbors" later and make it 0(to mark visited).
from collections import deque
class Solution:
    def numIslands(self, grid):
        if grid == None or len(grid) == 0: return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        q = deque()
        # direction array for navigation along 4 directions
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        for i in range(m):
            for j in range(n):
                # When u encounter 1, found land- examine its extent of 4 corners. Then move to these extents and repeat.
                if grid[i][j] == '1':
                    # increase count when new land found!
                    count += 1
                    q.append((i,j))
                    # mark visited
                    grid[i][j] = '0'
                    while q:
                        cr, cc = q.pop()
                        for d in dirs:
                            r, c = d[0] + cr, d[1] + cc
                            # checking extent of this new found land!
                            if r>=0 and c>=0 and r<m and c<n and grid[r][c] == '1':
                                q.append((r,c))
                                grid[r][c] = '0'
        return count