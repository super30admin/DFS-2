# Time Complexity - O(m*n)
# Space Complexity - O(m*n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        q = []
        count = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1" : 
                    count += 1 
                    
                    grid[i][j] = "0"

                    q.append([i,j])
                
        
                    while q : 
                        curr = q.pop(0)
                        for each in dirs:
                            nr = curr[0]+ each[0]
                            nc = curr[1]+ each[1]
                            if nr >= 0 and nc >= 0 and nr < m and nc <n and grid[nr][nc] == "1": 
                                grid[nr][nc] = "0"
                                q.append([nr,nc])
           
        return count

# DFS

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        self.count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1" : 
                     self.count += 1
                     self.dfs(grid,i,j,m,n,dirs)

        return self.count

                   
    def dfs(self,grid,sr,sc,m,n,dirs):
        if sr < 0 or sc < 0 or sr == m or sc == n or grid[sr][sc] == "0": 
            return

        grid[sr][sc] = "0"
       
        for each in dirs:
            nr = sr+ each[0]
            nc = sc+ each[1]
            self.dfs(grid,nr,nc,m,n,dirs)
                
               



        



                    


        



                    
