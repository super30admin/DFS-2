
'''
 Time Complexity : 0(m*n)
 Space Complexity : 0(m*n)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : Nope


 Your code here along with comments explaining your approach

- Created a clone of the graph with a boolean values which represents whether the cell in the grid
is visited or not

- Traversed the  grid and check whether the cell is '1' and not visited
- If its not then we make a dfs traversal in the next coordinates,

'''

class Solution:
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        self.R=len(grid)
        self.C=len(grid[0]) if self.R!=0 else 0
        
        visited = [ [False]*self.C  for _ in range(self.R)]
        numberOfislands=0
        
        for i  in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j]=="1" and not visited[i][j]:
                    self.dfs(i,j,grid,visited)
                    numberOfislands+=1
                    
        return numberOfislands
    
    def dfs(self,x,y,grid,visited):
        
        if x>=self.R or y>=self.C or x<0 or y<0:
            return
        
        if grid[x][y]=="0" or visited[x][y]:
            return
        
        visited[x][y] = True
        for dx,dy in ((x,y-1),(x,y+1),(x-1,y),(x+1,y)):
          self.dfs(dx,dy,grid,visited)
        
        return