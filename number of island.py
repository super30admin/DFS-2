#// Time Complexity : o(n)
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
class Solution:
    def dfs(self,r,c,grid,dr,dc,n,m):
        grid[r][c] = -1
        # print("dfs->",grid)
        for i in range(4):
            nrow = r + dr[i]
            ncol = c + dc[i]
            if nrow >= 0 and nrow < n and ncol>=0 and ncol < m and grid[nrow][ncol]  == "1" and grid[nrow][ncol] != -1 :
                self.dfs(nrow,ncol,grid,dr,dc,n,m)
    
    
    def numIslands(self, grid: List[List[str]]) -> int:
        dr = [-1,0,1,0]
        dc = [0,1,0,-1]
        ans = 0
        n = len(grid)
        m = len(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != -1 and grid[i][j] != "0" :
                        self.dfs(i,j,grid,dr,dc,n,m)  
                        ans += 1
        # print(grid)
        return ans  

# Approach:
# 1. We will use DFS to traverse the grid and mark the visited cells as -1.
# 2. We will traverse the grid and for each cell if it is not visited and not 0
# we will call the dfs function and increment the ans by 1.
# 3. We will return the ans.