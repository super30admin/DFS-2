# Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
# Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
# Yes, It ran on leetcode without any problems

class Solution:
    def numIslands(self, grid) -> int:
        if not grid:
            return 0
        count = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    count += 1
                    self.island(grid,i,j)
        return count
    
    def island(self,grid,r,c):
        if 0<=r<len(grid) and 0<=c<len(grid[0]) and grid[r][c]=="1":
            grid[r][c]="2"
            
            self.island(grid,r+1,c)
            self.island(grid,r-1,c)
            self.island(grid,r,c+1)
            self.island(grid,r,c-1)