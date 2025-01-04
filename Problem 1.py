class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        #first bfs first
        #secondly dfs

        q = deque()
        count = 0
        dirs = [(1, 0), (-1, 0), (0, -1), (0, 1)]
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == '1':
                    count+=1
                    #bfs
                    q.append((r,c))
                    grid[r][c] = "0"

                    while q:
                        i, j = q.popleft() #remember
                
                        for r_, c_ in dirs:
                            nr, nc = i + r_, j + c_
                            if not 0 <= nr < ROWS or not 0 <= nc < COLS or grid[nr][nc] != "1":
                                continue
                            q.append((nr, nc))
                            grid[nr][nc] = "0"


        return count
        





  

