# Using DFS
# Time complexity : O(n*m)
# Space complexity : O(n*m)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # find rows and cols and see if it null or len is 0
        rows = len(grid)
        if not grid or rows == 0:
            return 0

        cols = len(grid[0])
        
        # dir array to check neighbor values
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        self.count = 0
        for i in range(rows):
            for j in range(cols):
                # whenever we find 1, increment count by 1, which is the number of islands
                # call the dfs on the index
                if grid[i][j] == '1':
                    self.count += 1
                    self.dfs(grid, i, j, rows, cols, dirs)
        return self.count
    
    def dfs(self, grid, row, col, rows, cols, dirs):
        # base - boundary condition, then just return
        if row < 0 or row > rows or col < 0 or col > cols or grid[row][col] != '1':
            return
        # logic
        # make the grid to some value other than 1, to mark it visited
        grid[row][col] = '2'
        
        # check for neigbors
        for di in dirs:
            r = row + di[0]
            c = col + di[1]
            # if neighbor is within boundary and has value 1, then expore that index
            if r >= 0 and r < rows and c >= 0 and c < cols and grid[r][c] == '1':
                self.dfs(grid, r, c, rows, cols, dirs)
