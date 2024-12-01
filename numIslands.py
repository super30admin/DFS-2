"""
Approach:
start with land ("1") perform dfs on all 4 directions and mark the cell as visited ("0") simultaneously, increment numIsland after dfs
repeat for the next land
TC: O(n*m) In worstcase where all cells are "1"
SP: O(n*m) recursive stack space

"""

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        direction = [(-1,0), (1, 0), (0, -1), (0, 1)]
        numIsland=0
        def dfs(r, c):
            grid[r][c]="0"
            for dr, dc in direction:
                nr, nc = dr+r, dc+c
                if (0 <=nr < rows and 0<=nc< cols) and  grid[nr][nc] == "1":
                    dfs(nr, nc)
        for i in range(rows):
            for j in range(cols):
                if grid[i][j]=="1":
                    dfs(i,j)
                    numIsland+=1
                
        return numIsland




        




        