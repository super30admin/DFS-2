# Time Complexity :O(m*n) as it's matrix number of elements are m*n
# Space Complexity : O(m*n) as it's matrix number of elements are m*n
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution:
    
    def dfs(self,grid,row,col):
        grid[row][col]="0"
        lst=[(row-1,col),(row+1,col),(row,col-1),(row,col+1)]
        for row,col in lst:
            if row>=0 and col>=0 and row<len(grid) and col<len(grid[row]) and grid[row][col]=="1":
                self.dfs(grid,row,col)
    
    def numIslands(self, grid: List[List[str]]) -> int:
        island=0
        for r in range(len(grid)):
            for c in range(len(grid[r])):
                if grid[r][c] == "1":
                    self.dfs(grid,r,c)
                    island+=1
                    
        return island 