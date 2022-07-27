# Time Complexity => O(N^2)
# Space Complexity => O(M*N)
# DFS Approach
from pip import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if(len(grid)==0):
            return 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        icount = 0
        def traverse(grid, a, b):
            if(a<0 or a>=m or b<0 or b>=n or grid[a][b]!="1"):
                return
            grid[a][b] = "0"
            for x,y in dirs:
                traverse(grid, a+x, b+y)
                
        for i in range(m):
            for j in range(n):
                if(grid[i][j]=="1"):
                    icount+=1
                    traverse(grid,i,j)
        return icount


# BFS Approach
# Time Complexity => O(N^2)
# Space Complexity => O(min(M,N))
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if(len(grid)==0):
            return 0
        m = len(grid)
        n = len(grid[0])
        queue = []
        finalcount = 0
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        for i in range(m):
            for j in range(n):
                if(grid[i][j]=="1"):
                    finalcount+=1
                    grid[i][j] = "0"
                    queue.append([i,j])
                    while(len(queue)!=0):
                        curr = queue.pop(0)
                        for a,b in dirs:
                            nr = curr[0]+a
                            nc = curr[1]+b
                            if(nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc]=="1"):
                                queue.append([nr,nc])
                                grid[nr][nc]= "0"
        return finalcount
                                
                            
                    
        
        
                
        