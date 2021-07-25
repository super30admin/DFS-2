	# Time Complexity : O(mn)
	# Space Complexity : O(mn)
	# Did this code successfully run on Leetcode : Yes
	# Any problem you faced while coding this : No

# for each occurence of 1 apply dfs or bfs

#bfs is efficient since extra space will be O(min(m,n))
class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        self.m = len(grid)
        self.n = len(grid[0])
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    self.dfs(grid,i,j)
                    count += 1
        return count
    
    def dfs(self,grid,r,c):
        
        if r < 0 or r >= self.m or c < 0 or c >= self.n or grid[r][c] != "1":
            return;
        grid[r][c] = 0
        dirs = [[1,0],[-1,0],[0,-1],[0,1]]
        
        for i in dirs:
            x = r + i[0]
            y = c + i[1]
            self.dfs(grid,x,y)