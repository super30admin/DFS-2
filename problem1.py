// Time Complexity :O(n*m + n*m)
// Space Complexity :O(n*m) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or len(grid)==0 or not grid[0] or len(grid[0])==0:
            return 0
        
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        n=len(grid)
        m=len(grid[0])
        cnt=0
        for i in range(n):
            for j in range(m):
                if grid[i][j]=='1':         //check if the current index has value 1 then update all its neighbours which have value 1 to 0 by applying dfs 
                    self.recurr(grid,i,j)
                    cnt+=1
        return cnt
    
    def recurr(self,grid,i,j):
        grid[i][j]='0'              //update the current index as 0 and again call recursive call to its four neighbours.
        for dir in self.dirs:
            r=i+dir[0]
            c=j+dir[1]
            
            if r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c]=='1':
                self.recurr(grid,r,c)
