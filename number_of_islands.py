class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        ## DFS Solution
        ## T.C = O(m.n)
        ## S.C = O(m.n)
        
        ROWS, COLS = len(grid), len(grid[0])
        islands = 0
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        
        def dfs(grid, p, q):
            nonlocal dirs

            grid[p][q] = "0"
            for i, j in dirs:
                if p+i in range(ROWS) and q+j in range(COLS) and grid[p+i][q+j] == "1":
                    dfs(grid, p+i, q+j)
        
        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == "1":
                    dfs(grid, i, j)
                    islands += 1
        
        return islands
        
        ##############################################
        ## BFS Solution
        ## T.C = O(m.n)
        ## S.C = O(m.n)
        
        ROWS, COLS = len(grid), len(grid[0])
        islands = 0

        def bfs(grid, x, y):
            dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
            queue = [[x, y]]

            while queue:
                p, q = queue.pop(0)
                for i, j in dirs:
                    if p+i in range(ROWS) and q+j in range(COLS) and grid[p+i][q+j] == "1":
                        grid[p+i][q+j] = "0"
                        queue.append([p+i, q+j])
        
        for m in range(ROWS):
            for n in range(COLS):
                if grid[m][n] == "1":
                    grid[m][n] = "0"
                    bfs(grid, m, n)
                    islands += 1

        return islands