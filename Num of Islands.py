#  Time Complexity : O(nm)  - > 2mn
#  Space Complexity : O(mn)  
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No 

# Use DFS
# Iterate through the whole matrix
# find if grid[i][j]==1
# go into DFS make grid[i][j]=#
# go into all 4 directions of i,j and check same

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if grid == None or len(grid)==0:
            return 0
        count=0
        
        directions = [(1,0),(0,1),(-1,0),(0,-1)]
        def dfs(r,c):
            #base
            if(r<0 or c<0 or r>=len(grid) or c>=len(grid[0]) or grid[r][c]=="#" or grid[r][c]=="0"):
                return
            
            #logic
            grid[r][c]="#"
            for dir in directions:
                rd = dir[0]+r
                cd = dir[1]+c
                if((rd>=0 and cd>=0 and rd<len(grid) and cd<len(grid[0])) and grid[rd][cd]=="1"):
                    dfs(rd,cd)
                    
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    count+=1
                    dfs(i,j)
        
        return count
                    
        