# problem 1

class Solution(object):
    
    def checkNeighbour(self,grid,i,j,row,col):
        if i >= 0 and j >= 0 and i<row and j<col: 
            if grid[i][j] == '1':
                grid[i][j] = '0'
                self.checkNeighbour(grid,i-1,j,row,col)
                self.checkNeighbour(grid,i,j-1,row,col)
                self.checkNeighbour(grid,i+1,j,row,col)
                self.checkNeighbour(grid,i,j+1,row,col)
        
    
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        count = 0
        row = len(grid)
        if row == 0:
            return count
        col = len(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    self.checkNeighbour(grid,i,j,row,col)
                    count+=1 
        return count
                    
                    
                