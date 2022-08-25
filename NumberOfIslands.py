# Time Complexity : O(M * N) As it traverse the whole array
#  Space Complexity : O(1) or O(H) Ignoring recursive stack it is O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid:
            return 0
        
        #Declare variable to check bounds of matrix
        m = len(grid)
        n = len (grid[0])
        total = 0
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        
        #DFS function to traverse the matrix and make 1's to 0's recursievly to all direction
        def dfs(grid, r,c):
            if r< 0 or c< 0 or r==m or c==n or grid[r][c] !="1":
                return
 
            grid[r][c] = "0"
            
            for dr,dc in dirs:
                nr=r+dr
                nc=c+dc
                dfs(grid,nr,nc)
                    
        #Traverse the matrix and seprate out the 0's
        for i in range(m):
            for j in range(n):
                
                if grid[i][j] == "1":
                    total+=1
                    dfs(grid,i,j)
        return total