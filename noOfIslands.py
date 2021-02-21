#TimeComplexity:O(N*M) 
#SpaceComplexity: Space for queue
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    '''
    def dfs(self,grid,i,j,m,n):
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        for dir in dirs:
            x=i+dir[0]
            y=j+dir[1]
            if (x>=0 and y>=0 and x<m and y<n and grid[x][y]=='1'):
                grid[x][y]='0'  
                self.dfs(grid,x,y,m,n)
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid) ; n=len(grid[0])
        count=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    self.dfs(grid,i,j,m,n)
                    count+=1
        return count        
    '''
    def bfs(self,grid,i,j,m,n):
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        queue=[(i,j)]
        grid[i][j]='0'
        while(queue):
            queue1=[queue.pop(0)]
            for dir in dirs:
                x=queue1[0][0]+dir[0]
                y=queue1[0][1]+dir[1]
                if (x>=0 and y>=0 and x<m and y<n and grid[x][y]=='1'):
                    grid[x][y]='0'
                    queue.append([x,y])
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid) ; n=len(grid[0])
        count=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    self.bfs(grid,i,j,m,n)
                    count+=1
        return count
