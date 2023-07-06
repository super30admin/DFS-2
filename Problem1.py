# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  Uses Depth-First Search (DFS) to traverse through the given grid. 
#  Each time a "1" cell is found, a DFS is triggered to mark the connected "1" cells.
#  We also the increment the count of islands every time it happens.
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid or not grid[0]:
            return 0
        
        res = 0
        
        def dfs(r, c):
            dirs = [(0,1), (1,0), (-1,0), (0, -1)]
            for dr, dc in dirs:
                nr = r+dr
                nc = c+dc
                if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and grid[nr][nc] == "1":
                    grid[nr][nc] = "#"
                    dfs(nr, nc)
        
        
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == "1":
                    grid[r][c] = "#"
                    dfs(r, c)
                    res += 1
        
        return res
                