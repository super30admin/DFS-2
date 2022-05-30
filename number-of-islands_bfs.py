# Time Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Space Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        q = deque()
        total = 0
        
        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == "1":
                    total += 1
                    q.appendleft((i, j))
                    grid[i][j] = "2"
                    while len(q) != 0:
                        land = q.pop()
                        r, c = land
                        for d in dirs:
                            nr = r + d[0]
                            nc = c + d[1]
                            if nr >= 0 and nr < ROWS and nc >=0 and nc < COLS and grid[nr][nc] == "1":
                                grid[nr][nc] = "2"
                                q.appendleft((nr, nc))            
        return total