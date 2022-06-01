#Time Complexity : O(m*n)
#Space Complexity : O(MIN(m,n))
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        row = len(grid)
        col = len(grid[0])
        dir = [[1,0],[0,1],[-1,0],[0,-1]]
        count = 0
        queue = []
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    count+=1
                    queue.append([i,j])
                    grid[i][j] = '0'
                    while queue:
                        node = queue.pop(0)
                        for k in dir:
                            r = k[0] + node[0]
                            c = k[1] + node[1]   
                        
                            if r >= 0 and c >=0 and r < row and c < col and grid[r][c] == '1':
                                queue.append([r,c])
                                grid[r][c] = '0'
                                
        return count  

#DFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.row = len(grid)
        self.col = len(grid[0])
        self.dir = [[1,0],[0,1],[-1,0],[0,-1]]
        count = 0
        for i in range(self.row):
            for j in range(self.col):
                if grid[i][j] == '1':
                    count+=1
                    self.dfs(grid,i,j)         
        return count
                    
    def dfs(self,grid,i,j):
        #base
        if i<0 or j<0 or i==self.row or j==self.col or grid[i][j] == '0':
            return 
        #logic
        grid[i][j] = '0'
        for k in self.dir:
            r = i + k[0]
            c = j + k[1]
            self.dfs(grid,r,c)  
                        

        