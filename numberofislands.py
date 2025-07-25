#Time Complexity: O(m*n)
#Space Complexity: O(m*n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        dirs=[[-1,0],[0,-1],[0,1],[1,0]]
        count=0
        def dfs(r,c):
            if r<0 or c<0 or r==m or c==n or grid[r][c]!='1':
                return
            grid[r][c]='0'

            for k in dirs:
                nr=r+k[0]
                nc=c+k[1]
                dfs(nr,nc)
            return

        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    count+=1
                    dfs(i,j)

        return count