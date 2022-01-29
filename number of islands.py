# Time Complexity - O(mn)
# Space Complexity - O(mn)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0:
            return 0
        q = deque()
        count = 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    count=count+1
                    grid[i][j]='0'
                    q.append((i,j))
                    while q: 
                        curr=q.popleft()
                        for dir1 in dirs:
                            r = curr[0]+dir1[0]
                            c = curr[1]+dir1[1]
                            if r>=0 and r<m and c>=0 and c<n and grid[r][c]=='1':
                                grid[r][c]='0'
                                q.append((r,c))
        return count
        
    '''
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0 and len(grid[0])==0:
            return 0
        count = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    count = count+1
                    self.dps(grid,i,j,m,n)
        return count
    
    def dps(self,grid,i,j,m,n):
        #base
        if i<0 or j<0 or i==m or j==n or grid[i][j]=='0':
            return
        #logic
        grid[i][j]='0'
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        for dir1 in dirs:
            r = i+dir1[0]
            c = j+dir1[1]
            self.dps(grid,r,c,m,n)'''
