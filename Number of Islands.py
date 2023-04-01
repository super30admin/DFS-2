# Time Complexity: O(n*m)
# Space Complexity: O(n*m)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # BFS APPROACH
        global count, rowlen, collen, dirs
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        rowlen = len(grid)
        collen = len(grid[0])
        count = 0

        # dq = deque()
        # for i in range(rowlen):
        #     for j in range(collen):
        #         if grid[i][j] == '1':
        #             count += 1
        #             dq.append((i,j))
        #             grid[i][j] = '0'
        #             while dq:
        #                 r,c = dq.popleft()
        #                 # grid[r][c] = '0'
        #                 for dirr in dirs:
        #                     nr = r + dirr[0]
        #                     nc = c + dirr[1]
        #                     if nr >=0 and nc >= 0 and nr < rowlen and nc < collen and grid[nr][nc] == '1':
        #                         dq.append((nr,nc))
        #                         grid[nr][nc] = '0'
        # return count

        # DFS APPROACH
        def dfs(grid, r, c):
            global dirs, rowlen, collen
            for dirr in dirs:
                nr = r + dirr[0]
                nc = c + dirr[1]
                if nr >= 0 and nc >= 0 and nr < rowlen and nc < collen and grid[nr][nc] == '1':
                    grid[nr][nc] = '0'
                    dfs(grid, nr, nc)

        for i in range(rowlen):
            for j in range(collen):

                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] = '0'
                    dfs(grid, i, j)
        return count





