#bfs
#TC O(mn)
#SC O(m+n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        m=len(grid)
        n=len(grid[0])
        dirs=[[0,-1],[0,1],[-1,0],[1,0]]
        def bfs(r,c):
            q=deque()
            q.append((r,c))
            while q:
                r,c = q.popleft()
                for i,j in dirs:
                    row=r+i
                    col=c+j
                    if row in range(m) and col in range(n) and grid[row][col]=='1':
                        grid[row][col]='2'
                        q.append((row,col))              

        cnt=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    cnt+=1
                    bfs(i,j)
        return cnt
        
        
#dfs
#TC O(mn)
#SC O(mn)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        m=len(grid)
        n=len(grid[0])
        dirs=[[0,-1],[0,1],[-1,0],[1,0]]
        def dfs(r,c):
            if r not in range(m) or c not in range(n) or grid[r][c]!='1':
                return
            grid[r][c]='2'
            for i,j in dirs:
                row=r+i
                col=c+j
                dfs(row,col)

        cnt=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    cnt+=1
                    dfs(i,j)
        return cnt
        
        