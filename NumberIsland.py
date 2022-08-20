#200. Number of Islands
"""
Time Complexity : O(m*n) #going through all elements of matrix
Space COmplexity : O(m*n) #stack
"""
class Solution:
    dirs = [[0,1], [0,-1], [-1,0], [1,0]]
    #         R       L       U      D
    
    def dfs(self, grid, r, c):
        #base
        if r < 0 or r > len(grid)-1 or c < 0 or c > len(grid[0])-1 or grid[r][c] == '0' :
            return
        
        #logic
        grid[r][c] = '0' #mark as visited
        for d in self.dirs:
            nr = r + d[0]
            nc = c + d[1]
            
            self.dfs(grid, nr, nc)
        
        
    def numIslands(self, grid: List[List[str]]) -> int:
        #null case
        if len(grid) == 0:
            return 0
        
        
        count = 0
        
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                
                if grid[r][c] == '1':
                    count += 1
                    self.dfs(grid, r, c)
                    
        return count
                    
        
