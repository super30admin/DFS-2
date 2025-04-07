"""
Problem1 (https://leetcode.com/problems/number-of-islands/)
"""

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        """
        Using BFS TC: O(m * n)  { 2 O(m*n)}
                  SC: min (O(m,n))
        """
        dirs_ = [[1,0], [0,1], [-1, 0 ], [0, -1]]
        island_qu = collections.deque()
        no_islands = 0
        
        m = len(grid)
        n = len(grid[0])
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    
                    no_islands += 1
                    island_qu.append((i,j))
                    grid[i][j] = "0"
                    
                    while island_qu:
                        r, c = island_qu.popleft()
                        for d in dirs_:
                            nr = d[0] + r
                            nc = d[1] + c
                            
                            if (nr >=0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == "1" ):
                                grid[nr][nc] = "0"
                                island_qu.append((nr,nc))
                            
                            
        return no_islands


    def numIslands(self, grid: List[List[str]]) -> int:
        """
        Using DFS TC: O(m * n)  { 2 O(m*n)}
                  SC: O(m * n)
        """
        dirs_ = [[1,0], [0,1], [-1, 0 ], [0, -1]]
        no_islands = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    no_islands += 1
                    #grid[i][j] = "0"
                    self.dfs(grid, i, j, dirs_)
                    
        return no_islands
                    
             
    def dfs(self, grid, i, j, dirs_):
        # BASE
        if (i < 0 or j <0 or i == len(grid) or j == len(grid[0])):
            return
        
        
        # LOGIC
        if grid[i][j] == "1":
            grid[i][j] = "0"
            for d in dirs_:
                nr = d[0] + i
                nc = d[1] + j
                self.dfs(grid, nr, nc, dirs_)
        
        
                    