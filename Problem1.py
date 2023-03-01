"""
Problem1 (https://leetcode.com/problems/number-of-islands/)
"""

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        """
        Using BFS 
        TC: 2* O(M*N)
        SC: min of M or N
        """
        if not grid: return 0 
        # m = rows; n = cols
        m = len(grid) 
        n = len(grid[0])
        dir = [[1,0],[0,1], [-1,0],[0,-1]]
        numOfIsland = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    numOfIsland += 1
                    q = collections.deque(tuple())
                    q.append((i,j))
                    grid[i][j] = "0"
                    while q:
                        r,c = q.popleft()
                        for d in dir:
                            nr = d[0] + r
                            nc = d[1] + c
                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == "1":
                                q.append((nr, nc))
                                grid[nr][nc] = "0"


                        
        return numOfIsland

#Approach - 2

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        """
        Using DFS
        TC: O(M*N)
        SC: O(MN)
        """
        if not grid: return 0 
        # m = rows; n = cols
        
        m = len(grid) 
        n = len(grid[0])
        dir = [[1,0],[0,1], [-1,0],[0,-1]]
        numOfIsland = 0
        def dfs(grid, r, c):
            #Base Case
            if(r <0 or c<0 or r == m or c == n or grid[r][c] == "0"):
                return
            #Logic
            grid[r][c] ="0"
            for d in dir:
                nr = d[0] + r
                nc = d[1] + c
                dfs(grid,nr,nc)
 
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    numOfIsland += 1
                    dfs(grid, i, j)

                        
        return numOfIsland



