# Time Complexity (DFS Approach) :
# O(M*N)   , M rows and N cols

# Space Complexity (DFS Approach) :  
# O(1) , In-place modification



class Solution(object):
    def __init__(self):
        self.rows = 0
        self.cols = 0
        self.dirs = [[-1,0], [1,0], [0,-1], [0, 1]]

    def numIslands(self, grid):
        if not grid or len(grid)==0:
            return 0
        
        self.rows = len(grid)
        self.cols = len(grid[0])  

        count = 0

        for i in range(0, self.rows):
            for j in range(0, self.cols):
                if grid[i][j] == "1":
                    count += 1
                    self.dfs(grid, i, j)
        
        return count

    
    def dfs(self, grid, row, col):
        # base
        if row<0 or row>=self.rows or col<0 or col>=self.cols or grid[row][col] != "1":
            return

        # logic
        # 1. Mark current node as visited, use a number other than 0 and 1 to encode
        grid[row][col] = 2

        # 2. Start 4-direction recursive calls
        for dir in self.dirs:
            nr = row + dir[0]
            nc = col + dir[1]
            self.dfs(grid, nr, nc)