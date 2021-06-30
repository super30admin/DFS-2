# Time Complexity : O(M*N) 
# Space Complexity :    min O(M*N) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


#BFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0:
            return 0
        count = 0
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        m = len(grid)
        n = len(grid[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    count+=1
                    q.append([i,j])                   
                    while(len(q)):
                        ele = q.popleft()
                        r = ele[0]
                        c = ele[1]
                        for d in dirs:
                            nr = r+d[0]
                            nc = c+d[1]
                            if nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]=='1':
                                grid[nr][nc]='0'
                                q.append([nr,nc])
        return count
    
    
                        
                        
#DFS
# Time Complexity: O(m x n)
# Space Complexity: O(m x n)
class Solution:
    def __init__(self):
        self.dirs = [[1,0],[0,1],[-1,0],[0,-1]]

    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0:
            return 0
        m = len(grid)
        n = len(grid[0])
        count=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    count+=1
                    self.dfs(grid,i,j,m,n)
                    
        return count
    
    def dfs(self,grid,r,c,m,n):
        
        if r<0 or c<0 or r==m or c==n or grid[r][c]!='1':
            return
        grid[r][c]='0'
        
        for d in self.dirs:
            nr = d[0]+r
            nc = d[1]+c
            self.dfs(grid,nr,nc,m,n)   


    