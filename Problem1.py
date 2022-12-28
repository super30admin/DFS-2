T.C: O(m*n)
S.C: min(m,n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        c = 0
        q = []
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    c += 1
                    q.append([i,j])
                    while q:
                        ci,cj = q.pop(0)
                        for x,y in dirs:
                            x += ci
                            y += cj
                            if x>=0 and y>=0 and x<m and y < n and grid[x][y] =='1':
                                grid[x][y] = '0'
                                q.append([x,y])
        return c
        
