# Time Complexity= O(m * n)
# Space Complexity = O(m * n)

# Using DFS
class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        
        islands = 0
        
        self.m = len(grid)
        self.n = len(grid[0])
        
        # Directions - down, right, left, up
        self.dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        
        
        # If the element is "1", carry the DFS and increase the number of islands
        for i in range (self.m):
            for j in range (self.n):
                if grid[i][j] == "1":
                    self.dfs(i, j, grid)
                    islands += 1                # Counting the number of times DFS is done
                    
        
        return islands
    
    
    def dfs(self, r, c, grid):
        # Base Case
        # Checking for boundary conditions, edge cases
        if (r < 0 or r == self.m or c < 0 or c == self.n or grid[r][c] != "1"):
            return
        
        # Logic
        # Changing the "1" to "0", as soon as dfs begins for that node/element
        grid[r][c] = "0"
        
        # Calculating the new row and col to check the element
        for d in self.dirs:
            nr = r + d[0]
            nc = c + d[1]
            self.dfs(nr, nc, grid)
            
          
            
            
# Using BFS
# Time Complexity = O(m * n)
# Space Complexity = O(min(m, n)), coz at a time, only the diagonal elements are enteringthe queue and they are equal to the min b/w rows and cols

class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        
        islands = 0
        
        m = len(grid)
        n = len(grid[0])
        
        # Directions - down, right, left, up
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        
        q = []
        
        # If the element is "1", carry the BFS and increase the number of islands
        for i in range (m):
            for j in range (n):
                if grid[i][j] == "1":
                    islands += 1                # Counting the number of times BFS is done
                    grid[i][j] = "0"            # Replace 1 with 0
                    q.append([i, j])            
        
        
                    # Starting BFS
                    while q:
                        curr = q.pop(0)
                        for d in dirs:
                            nr = curr[0] + d[0]
                            nc = curr[1] + d[1]
                            
                            # Boundary conditions
                            if (nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == "1"):
                                q.append([nr, nc])
                                grid[nr][nc] = "0"
        
        
        return islands
        
                