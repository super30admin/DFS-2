// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        def dfs(grid,i,j): #perform dfs to go from one subtree to its child
            
            for dirs in self.directions:
                r=i+dirs[0]
                c=j+dirs[1]
                
                if r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c]=="1": # go to adjacent values only if it's 1
                    grid[r][c]="2"
                    dfs(grid,r,c)
                    
        if grid is None or len(grid)==0 or len(grid[0])==0:
            return 0
        count=0
        self.directions=[[-1,0],[0,1],[1,0],[0,-1]]
        for i in range(len(grid)):
            for j in range(len(grid[0])): 
                if grid[i][j]=="1": #for every 1 you find add to island count
                    count+=1
                    grid[i][j]="2"
                    dfs(grid,i,j)
                    
        return count #return final count
 