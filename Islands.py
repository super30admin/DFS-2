#Time Complexity: O(n)
#Space Complexity: O(h)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        directions=[[0,1],[0,-1],[-1,0],[1,0]]
        count=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    self.DFS(grid,i,j,m,n, directions)
        return count

    def DFS(self, grid,i, j, m,n,directions):
        if i<0 or i>=m or j<0 or j>=n or grid[i][j]=="0":
                return
        grid[i][j]="0"
        for d in directions:
            nr=i+d[0]
            nc=j+d[1]
            self.DFS(grid,nr,nc,m,n,directions)
                