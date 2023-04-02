#TC-O(mn)
#SC-O(mn)
#Logic-loop through array and on finding 1,do dfs and increase count by 1 for every new dfs
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(i,j):
            global dir
            global m
            global n
            for k in dir:
                cr=i+k[0]
                cc=j+k[1]
                if cr>=0 and cr<m and cc>=0 and cc<n and grid[cr][cc]=='1':
                    grid[cr][cc]='0'
                    dfs(cr,cc)
        global m
        m=len(grid)
        global n
        n=len(grid[0])
        global dir
        dir=[[-1,0],[0,1],[0,-1],[1,0]]
        
        count=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    dfs(i,j)
                
        return count
        