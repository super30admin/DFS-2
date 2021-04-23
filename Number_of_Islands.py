class Solution:
    
    #DFS approach
    def numIslands_dfs(self, grid: List[List[str]]) -> int:
        if not grid :
            return 
        count = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]== '1':
                    count +=1
                    self.dfs(grid,i,j)
        print(grid)
        return count                    
        
    def dfs(self,grid,row,column):
        
        #Base
        if(0 > row or row >= len(grid) or 0 > column or column >= len(grid[0]) or grid[row][column] != '1'):
            return
                    
        #Logic
        grid[row][column] = '0'
        dir_array = [(1,0),(0,1),(0,-1),(-1,0)]
        for i in dir_array:
            r = row + i[0]
            c = column + i[1]
            self.dfs(grid,r,c)
            
    #BFS approach            
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid:
            return
        
        queue = deque()        
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] == '0'
                    queue.append((i,j))
                    while queue:
                        element = queue.popleft()
                        row = element[0]
                        column = element[1]
                        dir_array = [(1,0),(0,1),(-1,0),(0,-1)]
                        for k in dir_array:
                            r = row + k[0]
                            c = column + k[1]
                            if 0<=r < m and 0 <= c < n and grid[r][c] == '1':
                                grid[r][c] = '0'
                                queue.append((r,c))
                
        return count    
            
                
        
