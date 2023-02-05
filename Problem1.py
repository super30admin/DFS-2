##Time Complexity :- O(mxn)
##Space Complexity:- O(mxn)
## Approach :- DFS
class Solution:
    m,n, total = 0, 0, 0
    dirs = [[0,1],[0,-1],[1,0],[-1,0]] 
    def numIslands(self, grid: List[List[str]]) -> int:
        queue = []
        self.m = len(grid)
        self.n = len(grid[0])
        self.total = 0
        

        
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == '1':
                    self.total+=1
                    self.dfs(i,j,grid)
        
        return self.total
    
    def dfs(self,r,c,grid):
        if r<0 or r==self.m or c<0 or c==self.n or grid[r][c]!='1':
            return
        grid[r][c] = '0'
        for dir in self.dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            self.dfs(nr,nc,grid)

                            
##Time Complexity :- O(mxn)
##Space Complexity:- O(mxn)
## Approach :- BFS


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        queue = []
        m = len(grid)
        n = len(grid[0])
        total = 0
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]

        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    queue.append([i,j])
                    total +=1
                    grid[i][j]='0'
                    while(len(queue)>0):
                        size = len(queue)
                        for k in range(size):
                            curr = queue.pop(0)
                            
                            for dir in dirs:
                                row = curr[0]+dir[0]
                                column = curr[1]+dir[1]
                                if row>=0 and row<m and column>=0 and column<n and  grid[row][column] == '1':
                                    grid[row][column] = '0'
                                    queue.append([row,column])
        
        
        return total
