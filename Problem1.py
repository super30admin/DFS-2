"""
200. Number of Islands
Time Complexity - O(n*m)
Space Complexity - O(n*m)
Go through each and every element in matrix and when value is 1 call dfs function 
dfs function will check all adjacent 1's in the matrix and once it explored all possible connected 1's weincrement count"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        count = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.dfs(grid,i,j)
                    count += 1
        return count
        
    def dfs(self,grid,row,column):
        grid[row][column] = 0
        direction = {(0,-1),(-1,0),(0,1),(1,0)}
        for dir in direction:
            r = dir[0] + row
            c = dir[1] + column
            if r >= 0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == '1':
                self.dfs(grid,r,c)
                
        