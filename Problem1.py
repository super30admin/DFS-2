# TC: O(rows*cols)
#SC: O(rows*cols) for DFS
#SC: O(min(rows, cols)) for bfs

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:     

        if not grid:
            return 0
        rows, cols = len(grid) , len(grid[0])
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        ans, q = 0, collections.deque()
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    q.append([r,c])
                    grid[r][c] = '0'
                    while q:
                        curr = q.popleft()
                        for dirn in self.dirs:
                            nr, nc = curr[0]+dirn[0], curr[1]+dirn[1]
                            if nr < rows and nc < cols and nr >= 0 and nc >= 0 and grid[nr][nc] == '1':
                                q.append([nr, nc])
                                grid[nr][nc] = '0'
                    ans += 1


       
        return ans

    #     if not grid:
    #         return 0
    #     self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    #     rows, cols = len(grid), len(grid[0])
    #     ans = 0
    #     for r in range(rows):
    #         for c in range(cols):
    #             if grid[r][c] == "1":
    #                 self.dfs(r, c, grid, rows, cols)

    #                 ans += 1
    #     return ans


    # def dfs(self, i, j, grid, rows, cols):
    #     if i < 0 or i == rows or j < 0 or j == cols or grid[i][j] != "1":
    #         return

    #     grid[i][j] = "0"
    #     for dirn in self.dirs:
    #         self.dfs(i+dirn[0], j+dirn[1], grid, rows, cols)
