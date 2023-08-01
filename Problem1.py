class Solution:
    # Time Complexity:O(m*n)
    # Space Complexity:O(min(m, n))
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        q = []
        count = 0
        for i in range(0, m):
            for j in range(0, n):
                if grid[i][j] == "1":
                    count += 1
                    q.append((i, j))
                    grid[i][j] = "0"
                    while q:
                        curr = q.pop(0)
                        for k in dirs:
                            nr = k[0] + curr[0]
                            nc = k[1] + curr[1]
                            if (
                                nr >= 0
                                and nc >= 0
                                and nr < m
                                and nc < n
                                and grid[nr][nc] == "1"
                            ):
                                q.append((nr, nc))
                                grid[nr][nc] = "0"
        return count
