# accepted on leetcode(200)
# time O(M*N), space - O(M*N)
class Solution:
    def numIslands(self, grid) -> int:
        # edge case
        if not grid: return 0
        m = len(grid)
        n = len(grid[0])
        queue = []
        # directions array
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        count = 0

        for i in range(m):
            for j in range(n):
                # Iterate through the grid and if we found 1 then increment the count and use the bfs approach to find the neighbouring 1's and make them 0.
                if grid[i][j] == '1':
                    count += 1
                    queue.append([i, j])
                    grid[i][j] = '0'

                    while queue:
                        curr = queue.pop(0)
                        for dir in dirs:
                            r = dir[0] + curr[0]
                            c = dir[1] + curr[1]
                            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == '1':
                                queue.append([r, c])
                                grid[r][c] = '0'
        return count