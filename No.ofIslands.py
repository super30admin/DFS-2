class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        row=len(grid)
        col=len(grid[0])
        q=[]
        dire=[[-1,0],[0,-1],[1,0],[0,1]]
        count=0
        for i in range(row):
            for j in range(col):
                if grid[i][j]=="1":
                    q.append([i,j])
                    grid[i][j]="0"
                    count+=1
                    while q:
                        c=q.pop(0)
                        for k in range(len(dire)):
                            cr=c[0]+dire[k][0]
                            cc=c[1]+dire[k][1]
                            if cr<0 or cc<0 or cr>=row or cc>=col: continue
                            if grid[cr][cc]=="0":continue
                            q.append([cr,cc])
                            grid[cr][cc]="0"
        return count

#code using dfs:

'''
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        row=len(grid)
        col=len(grid[0])
        q=[]
        dire=[[-1,0],[0,-1],[1,0],[0,1]]
        count=0
        def dfs(grid,r,c):
            grid[r][c]="0"
            for k in range(len(dire)):
                cr=r+dire[k][0]
                cc=c+dire[k][1]
                if cr<0 or cc<0 or cr>=row or cc>=col: continue
                if grid[cr][cc]=="1":
                    dfs(grid,cr,cc)
        for i in range(row):
            for j in range(col):
                if grid[i][j]=="1":
                    dfs(grid,i,j)
                    count+=1
        return count

'''

#code for dfs by JS
'''
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        row=len(grid)
        col=len(grid[0])
        q=[]
        dire=[[-1,0],[0,-1],[1,0],[0,1]]
        count=0
        def dfs(grid,r,c):
            if r<0 or c<0 or r>=row or c>=col or grid[r][c]=="0": return
            grid[r][c]="0"
            for k in range(len(dire)):
                cr=r+dire[k][0]
                cc=c+dire[k][1]
                dfs(grid,cr,cc)
        for i in range(row):
            for j in range(col):
                if grid[i][j]=="1":
                    dfs(grid,i,j)
                    count+=1
        return count
'''