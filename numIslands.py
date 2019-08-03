class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # Time Complexity: O(M*N)
        # Space Complexity: O(1)
        if not grid:
            return 0
        nrows = len(grid)
        ncols = len(grid[0])
        num_islands = 0
        for i in range(nrows):
            for j in range(ncols):
                if grid[i][j] == '1':
                    self.dfs(grid,i,j,nrows,ncols)
                    num_islands += 1
        return num_islands

    def dfs(self,grid,row,col,nrows,ncols):
        if grid[row][col] != '1':
             return
        directions = [(0,1),(1,0),(0,-1),(-1,0)]
        grid[row][col] = '-1'
        for direction in directions:
            new_row = row + direction[0]
            new_col = col + direction[1]
            if new_row >= 0 and new_row < nrows and new_col >= 0 and new_col < ncols: 
                 self.dfs(grid,new_row,new_col,nrows,ncols)
        
