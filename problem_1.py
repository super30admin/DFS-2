"""
problem_1: Number of Islands
TC: O(M*N) where M is the number of rows and N is the number of columns
SC: O(M+N) where M is the number of rows and N is the number of columns
Approach: Traverse through the grid and if we find a '1' then increment the result and do a BFS traversal to mark all the connected '1's as '2' so that we don't count them again.

"""


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or len(grid) == 0:
            return 0

        result = 0
        m = len(grid)
        n = len(grid[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # U D L R

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    queue = []
                    queue.append((i, j))
                    grid[i][j] = '2'
                    result += 1
                    while queue:
                        curr = queue.pop(0)
                        for dir_ in dirs:
                            nr = curr[0] + dir_[0]
                            nc = curr[1] + dir_[1]
                            if nr < m and nr >= 0 and nc >= 0 and nc < n and grid[nr][nc] == '1':
                                grid[nr][nc] = '2'
                                queue.append((nr, nc))

        return result

