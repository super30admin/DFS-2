# APPROACH 1: BFS 
# Time Complexity : O(2*m*n) => O(m*n), m: number of rows of grid, n: number of columns of grid, each cell is visited only a max of 2 times (onefor BFS and other for checking if 1)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Go through each element of grid. 
# 2. If cell value is 1, inc count and run BFS on it. Only traverse those cells that are 1 and change them to 0 so that we dont visit them again
# 3. For each cell check all it's 4 neighbors. 

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if grid is None:
            return 0
        
        dirs, island_count = [[0, 1], [0, -1], [1, 0], [-1, 0]], 0
        
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                
                if grid[row][col] == "1":
                    island_count += 1
                    grid[row][col] = "0"
                    queue = deque()
                    queue.append((row, col))
                    
                    while len(queue) > 0:
                        curr = queue.popleft()
                        for nei in dirs:
                            if curr[0] + nei[0] >= 0 and curr[0] + nei[0] < len(grid) and curr[1] + nei[1] >= 0 and curr[1] + nei[1] < len(grid[0]) and grid[curr[0] + nei[0]][curr[1] + nei[1]] == "1":
                                grid[curr[0] + nei[0]][curr[1] + nei[1]] = "0"
                                queue.append((curr[0] + nei[0], curr[1] + nei[1]))
                                
        return island_count



# APPROACH 2: DFS 
# Time Complexity : O(2*m*n) => O(m*n), m: number of rows of grid, n: number of columns of grid
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Go through each element of grid. 
# 2. If cell value is 1, inc count and run DFS on it. Only traverse those cells that are 1 and change them to 0 so that we dont visit them again
# 3. For each cell check all it's 4 neighbors. (recursively run DFS on them). 

class Solution:
    def __init__(self):
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if grid is None:
            return 0
        
        island_count = 0
        
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                
                if grid[row][col] == "1":
                    island_count += 1
                    self.dfs(grid, row, col)
                
        return island_count
    
    
    def dfs(self, grid, row, col):
        if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or grid[row][col] == "0":
            return
        
        grid[row][col] = "0"
        for nei in self.dirs:
            self.dfs(grid, row + nei[0], col + nei[1])                
