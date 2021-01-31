class Solution:
    
    """
    Description: Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands
    
    Time Complexicity: O(m*n)
    Space Complexicity: O(m*n) for DFS and min(m,n) for BFS
    where m and n are dimensions of the given matrix
    
    Approach: 
    Using BFS:
    - take a queue for indices starting when value == "1", change the value to "0" (avoid revisiting)
    - find all nearby "1" in all directions, add indices to queue again and replace by "0" until queue is empty
    - update count after each of the starting queue becomes empty
    
    Using DFS:
    - for first occuring value == "1", add a count, replace "1" by "0"
    - call dfs recursively by replacing all nearby "1" to "0", update count with every new "1" (after replacement)
    
    """
   
    def numIslands(self, grid: List[List[str]]) -> int:
        
        count = 0
        if grid == None or len(grid) == 0: return count
        self.dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        self.m = len(grid); self.n = len(grid[0])        
        
        for row in range(self.m):
            for col in range(self.n):
                if grid[row][col] == "1":
                    count += 1
                    self.dfs(grid, row, col)
        
        return count
    
    def dfs(self, grid, row, col):
        
        # base
        if row < 0 or col < 0 or row == self.m or col == self.n or grid[row][col] != "1": return
        
        # logic
        grid[row][col] = "0"
        for d in self.dirs:
            r = row + d[0]
            c = col + d[1]
            self.dfs(grid, r, c)
            
    def numIslands(self, grid: List[List[str]]) -> int:
        
        count = 0
        if grid == None or len(grid) == 0: return count
        from collections import deque
        
        queue = deque()
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        m = len(grid); n = len(grid[0])
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1; grid[i][j] = "0"
                    queue.append((i, j))
                    while queue:
                        curr = queue.popleft()
                        for d in dirs:
                            row = curr[0] + d[0]
                            col = curr[1] + d[1]
                            if row >= 0 and col >= 0 and row < m and col < n and grid[row][col] == "1":
                                grid[row][col] = "0"
                                queue.append((row,col))
                            
        return count
