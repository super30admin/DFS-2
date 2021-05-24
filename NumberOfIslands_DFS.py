# TC :O(M x N) where M = No. of rows and N = no. of columns
# SC: O(M x N) since we will be performing N dfs for each Mth node

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        count = 0
        
        def dfs(i, j):
            if i < 0 or i >= rows or j < 0 or j >= cols or grid[i][j] == '0':
                return 
            
            grid[i][j] = '0'
            dirs = [(0,1),(0,-1),(1,0),(-1,0)]
            for x,y in dirs: 
                new_x, new_y = i + x, j + y
                dfs(new_x, new_y)
        
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    count += 1
                    dfs(i, j)
        return count
