# BFS Appraoch
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        queue = collections.deque()
        
        row = len(grid)
        col = len(grid[0])
        directions = [[0,1], [0,-1], [-1,0], [1,0]]
        islands = 0
        
        for i in range(row):
            for j in range(col):
                
                if grid[i][j] == '1':
                    queue.append([i,j])
                    islands += 1
                    
                while queue:
                    coords = queue.popleft()
                    print(coords)
                    for direction in directions:
                        
                        nr  = coords[0] + direction[0]
                        nc = coords[1] + direction[1]
                        
                        if (nr<row and nc<col and nr>=0 and nc>=0 and grid[nr][nc] == '1'):
                            grid[nr][nc] = '0'
                            queue.append([nr,nc])
                            
                
                
        return islands
    
    # Time Complexity: O(M x N) ACtually it is 2 MN, for scanning the grid and another one for BFS
    # Space Complexity: O(min(M,N)) 

# DFS APPROACH

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        queue = collections.deque()
        
        row = len(grid)
        col = len(grid[0])
        directions = [[0,1], [0,-1], [-1,0], [1,0]]
        islands = 0
        
        def dfs(r,c):
            if grid[r][c] == '0':
                return
            
            
            grid[r][c] = '0'
            
            if r>=1:
                dfs(r-1,c)
            if r<row - 1:
                dfs(r+1,c)
                
            if c>=1:
                dfs(r,c-1)
            if c< col- 1:
                dfs(r, c + 1)
                
        
        for i in range(row):
            for j in range(col):
                if (grid[i][j] == '1'):
                    islands += 1
                    dfs(i,j)
                    
        return islands
    
    
    # Time Complexity: O(M x N) . ACtually it is 2 MN, for scanning the grid and another one for BFS
    # Space Complexity: O(M x N))