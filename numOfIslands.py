#DFS
#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid==None or len(grid)==0:
            return 0
        m=len(grid)
        n=len(grid[0])
        self.dirs=[[-1,0],[0,-1],[0,1],[1,0]]
        count=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    count+=1
                    self.dfs(grid,i,j,m,n)
        return count
    def dfs(self, grid, i, j, m, n):
        if i<0 or j<0 or i==m or j==n or grid[i][j]=='0':
            return
        grid[i][j]='0'
        for dir in self.dirs:
            nr=i+dir[0]
            nc=j+dir[1]
            self.dfs(grid, nr,nc,m,n)
        
    
#BFS
#Time Complexity:O(m*n)
#Space Complexity: O(m*n)
#DFS, BFS
#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid==None or len(grid)==0:
            return 0
        m=len(grid)
        n=len(grid[0])
        dirs=[[-1,0],[0,-1],[0,1],[1,0]]
        count=0
        q=collections.deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    q.append([i,j])
                    grid[i][j]=0
                    while q:
                        r,c=q.popleft()
                        for dir in dirs:
                            nr=r+dir[0]
                            nc=c+dir[1]
                            if nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]=='1':
                                grid[nr][nc]=0
                                q.append([nr,nc])
                    count+=1
        return count
