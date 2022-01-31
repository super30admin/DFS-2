#Time Complexity o(mn) Every element is visited once and bfs is triggered.
#Space Complexity o(1)
# dfs solution
# Start DFS Search whenever 1 is encountered

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
         
        if grid == None:
            return grid
        
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                
                if grid[i][j] == "1":
                    count +=1
                    self.dfs(grid,i,j,m,n,dirs)
        return count
                    
    def dfs(self ,grid , i , j , m , n , dirs):
        
        if i < 0 or j < 0 or i == m or j == n or grid[i][j] == "0":
            return
        
        
        grid[i][j] = "0"
        
        for dira in dirs:
            
            nr = i + dira[0]
            nc = j + dira[1]
            
            self.dfs(grid , nr , nc , m , n , dirs)
            
            
            
            
        
        