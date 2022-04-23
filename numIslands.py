class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        '''
        T = O(M*N)
        S = O(M*N)
        '''
        rows = len(grid)
        cols = len(grid[0])
        r = 0 
        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == "1":
                    r += self.bfs(grid, row, col)
        return r 
    
    def bfs(self, grid, row , col):
        rows = len(grid)
        cols = len(grid[0])
        dir_ = [ (1, 0) , (0, 1), (0, -1) , (-1, 0) ]
        q = []
        q.append((row, col))
        while q:
            row , col = q.pop(0)
            for d in dir_:
                r_ = row + d[0]
                c_ = col + d[1]
                if  0 <= r_ < rows and 0 <= c_ < cols and grid[r_][c_] == "1":
                        q.append((r_,c_))
                        grid[r_][c_] = "2"
        return 1
                
                
                
        
