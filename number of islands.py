# // Time Complexity : O(nxm) Where n is the number of rows and m is the number of columns
# // Space Complexity : O(nxm))
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

import collections
class Solution:
    def numIslands(self, grid) -> int:
        if not grid:
            return 0
        
        rows, cols = len(grid), len(grid[0])
        visit = set()
        islands = 0
        
        def bfs(r,c):
            q = collections.deque()
            visit.add((r,c))
            q.append((r,c))
            
            # expand island if queue not empty
            while q:
                row, col = q.popleft()
                directions = [[1,0],[-1,0],[0,1],[0,-1]]
                for dr, dc in directions:
                    r,c = row+dr, col+dc
                    if (r in range(rows) and
                        c in range(cols) and
                        grid[r][c] == "1" and
                        (r, c) not in visit):
                        q.append((r, c))
                        visit.add((r, c))
        
        # iterate through each cells of the grid
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1" and (r,c) not in visit:
                    bfs(r,c)
                    islands += 1
        return islands