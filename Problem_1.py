# Runs on Leetcode

# DFS solution 1
        # Runtime - O(n)
        # Memory - O(1)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        self.grid = grid
        self.count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.dfs(i,j)
                    self.count += 1
        return self.count
        
    def dfs(self,i,j):
        self.grid[i][j] = '0'
        if 0<=i+1<len(self.grid) and self.grid[i+1][j] == '1':
            self.dfs(i+1,j)
        if 0<=i-1<len(self.grid) and self.grid[i-1][j] == '1':
            self.dfs(i-1,j)
        if 0<=j+1<len(self.grid[0]) and self.grid[i][j+1] == '1':
            self.dfs(i,j+1)
        if 0<=j-1<len(self.grid[0]) and self.grid[i][j-1] == '1':
            self.dfs(i,j-1)
            
# DFS solution 2 
        # Runtime - O(n)
        # Memory - O(1)
                
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        self.grid = grid
        self.count = 0
        self.directions = [[0,1],[0,-1],[1,0],[-1,0]]
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.count += 1
                    self.dfs(i,j)
        return self.count
        
    def dfs(self,i,j):
        self.grid[i][j] = '0'
        for d in self.directions:
            x = i + d[0]
            y = j + d[1]
            if 0<=x<len(self.grid) and 0<=y<len(self.grid[0]) and self.grid[x][y] == '1':
                self.dfs(x,y)
                
                
# BFS solution
        # Runtime - O(n)
        # Memory - O(n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        count = 0
        queue = []
        directions = [[0,1],[0,-1],[1,0],[-1,0]]
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    count += 1
                    queue.append([i,j])
                    grid[i][j] = '0'
                    while queue:
                        element = queue.pop(0)
                        for d in directions:
                            x = element[0] + d[0]
                            y = element[1] + d[1]
                            if 0<=x<len(grid) and 0<=y<len(grid[0]) and grid[x][y]!='0':
                                queue.append([x,y])
                                grid[x][y] = '0'
        return count
