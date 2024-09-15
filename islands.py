// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if grid == [] or grid == None:
            return 0
        dx = [-1,0,1,0]
        dy = [0,1,0,-1]
        m = len(grid)
        n = len(grid[0])
        result = 0
        for i in range(m):
            for j in range(n):
                
                if grid[i][j] == "1":
                    result +=self.helper(grid,m,n, i,j,dx,dy)
                    
        return result    
                    
                
        
    def helper(self, grid,m,n,i,j,dx,dy):
        if not self.isvalid(i,j,m,n) or grid[i][j] == "0":
            return
        
        grid[i][j] = "0"
        for k in range(4):
            self.helper(grid,m,n,i+dx[k], j+dy[k], dx,dy)
        
        return 1
        
    def isvalid(self,i,j,m,n):
        if i>=0 and i<m and j>=0 and j<n:
            return True
        else:
            return False
        
                    