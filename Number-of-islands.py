# Time Complexity:  O(m*n)
# Space Complexity:  O(m*n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        def dfs(grid,i,j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != "1":
                return
            grid[i][j] = "0"
            for x, y in self.dirs:
                r = i + x
                c = j + y
                dfs(grid,r,c)
        
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    dfs(grid, i , j)
        
                
        