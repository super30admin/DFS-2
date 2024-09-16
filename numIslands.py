#Time Complexity=O(mn)
#Space Comlexity=O(mn)

#Ran succeesffuly on Leetcode:yes
#DFS Solution:

#Algorithm:
# 1. Firstly check for the location s in grid with valUES 0 And set them to 1 . 
# 2. To keep a track of the ones , keep a variable count.
# 3. Call DFS function to set that location to 1 and look for its neighbours and do the same. 
# 4. Return count.


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid)==0 :
            return 0
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    count+=1
                    self.dfs(grid,i,j)
        return count
    def dfs(self,grid,i,j):
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        
        if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j]=='0':
            return 
        grid[i][j]='0'
        for dx,dy in dirs:
            r=dx+i
            c=dy+j
            self.dfs(grid,r,c)
#BFS Solution     
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid) and len(grid[0])
        if grid is None or len(grid)==0 :
            return 0
        def bfs(i, j):
            q, grid[i][j] = [(i, j)], "0"
            for i, j in q:
                for x, y in ((i-1,j), (i+1,j), (i,j-1), (i,j+1)):
                    if 0 <= x < m and 0 <= y < n and grid[x][y] == "1":
                        grid[x][y] = "0"
                        q.append((x, y))
            return 1
			
	
        return sum(bfs(i,j) for i in range(m) for j in range(n) if grid[i][j] == "1")
          
