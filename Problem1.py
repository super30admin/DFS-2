#Number of Islands
# Time Complexity -> MxN
# Space Complexity - > mxn
# Logic -> whenevr encount 1 means it is part of some island, USE dfs to mark each point of the island as visited and then comtniue
# until next island is encountered



class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.rows = len(grid)
        self.columns = len(grid[0])
        self.result = 0
        for i in range(self.rows):
            for j in range(self.columns):
                if grid[i][j]=='1':
                    self.result+=1
                    self.markVisitedDfs(grid, i, j)
        return self.result
        
    
    def markVisitedDfs(self, grid, i, j):
        if i<0 or j<0 or i==self.rows or j==self.columns or grid[i][j]=='0' or grid[i][j]=='-1':
            return
        grid[i][j] = '-1'
        dirs=[(0,1),(0,-1),(1,0),(-1,0)]

        for r,c in dirs:
            self.markVisitedDfs(grid, r+i, c+j)