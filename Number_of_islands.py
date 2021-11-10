class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.names = '0'
        def dfs(x,y):
            if grid[x][y] == '1':
                grid[x][y] = self.names
                paths = [(0,1),(1,0),(0,-1),(-1,0)]
                for path in paths:
                    new_x = x + path[0]
                    new_y = y + path[1]
                    if new_x >= 0 and new_x < len(grid) and new_y >= 0 and new_y < len(grid[0]):
                        dfs(new_x,new_y)
            else:
                return
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.names = str(int(self.names) - 1)
                    dfs(i,j)
                    
        return -1 * int(self.names)