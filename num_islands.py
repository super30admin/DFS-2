# Time Complexity:O(mn) (where m:rows,n:columns)
# Space Complexity:O(mn)  (where m:rows,n:columns)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach: DFS approach.
# Start at the point where '1' is present.
# DFS all the neighboring 1's and mark them 0 so that they are not visited again.

class Solution:
    def numIslands(self,grid:List[List[str]])->int:
        if grid is None or len(grid)==0:
            return grid
        self.m,self.n = len(grid),len(grid[0])
        count = 0 
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == '1':
                    count+=1
                    self.dfs(grid,i,j)
        return count
    
    def dfs(self, grid, r, c):
        if r < 0 or c < 0 or r == self.m or c == self.n or grid[r][c] != '1':
            return 
        
        grid[r][c] = '0'
        dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        for dir in dirs:
            cr = r + dir[0]
            cc = c + dir[1]
            
            self.dfs(grid, cr, cc)
