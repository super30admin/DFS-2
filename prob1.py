#DFS SOLUTION
#TC:0(M X N)
#SC:0(M X N)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if (len(grid)==0 or grid == None):
            return 0
        total = 0
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        self.m = len(grid)
        self.n = len(grid[0])
        for i in range(self.m):
            for j in range(self.n):
                if(grid[i][j]=='1'):
                    total += 1
                    self.dfs(i,j,grid)
        
        return total
    
    
    def dfs(self,r,c,grid):
        if(r < 0 or c < 0 or r == self.m or c == self.n or grid[r][c]!='1'):
            return
        grid[r][c] = '0'
        for d in self.dirs:
            nr = d[0] + r
            nc = d[1] + c
            self.dfs(nr,nc,grid)


#BFS SOLUTION
#TC: 0(M X N)
#SC : (MIN (M X N))

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if (len(grid)==0 or grid == None):
            return 0
        total = 0
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if(grid[i][j]=='1'):
                    total += 1
                    q = []
                    grid[i][j]='0'
                    q.append([i,j])
                    while(len(q) != 0):
                        cur = q.pop(0)
                        for d in dirs:
                            nr = cur[0] + d[0]
                            nc = cur[1] + d[1]
                            if(nc >= 0 and nc < n and nr >= 0 and nr < m and grid[nr][nc]=='1'):
                                grid[nr][nc]='0'
                                q.append([nr,nc])
        
        return total