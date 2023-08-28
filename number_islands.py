class Solution:
    def __init__(self):
        self.directions = [[0,1] , [0,-1] ,[1,0] , [-1,0]]
        self.rows = 0
        self.cols = 0
    def numIslands(self, grid: List[List[str]]) -> int:

        self.rows = len(grid)
        self.cols = len(grid[0])
        islands = 0
        for i in range(self.rows):
            for j in range(self.cols):

                if grid[i][j] == '1':
                    islands +=1
                    ##Start DFS

                    self.dfs(grid , i , j)
        
        return islands

    
    def dfs(self,grid , row , col):
        
        ## base case
        if row < 0 or row >= self.rows or col < 0 or col >= self.cols or grid[row][col] != '1' :
            return

        #logic

        grid[row][col] = '0'

        for dirs in self.directions:
            nr = dirs[0] + row
            nc = dirs[1] + col

            self.dfs(grid , nr, nc)
