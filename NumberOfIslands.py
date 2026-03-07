# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We scan the entire grid for any unvisited '1' which marks the start of an island.
# Upon finding one, we use BFS to visit all connected land cells, marking them as '0'.
# This prevents revisits and lets us count each island exactly once.

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        dirs = [[-1, 0], [1, 0], [0,-1], [0, 1]]

        q = deque()
        count = 0

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    count += 1
                    q.append([i,j])
                    grid[i][j] = '0'

                    while q:
                        curr = q.popleft()
                        for dx, dy in dirs:
                            r = dx + curr[0]
                            c = dy + curr[1]

                            if 0 <= r < rows and 0 <= c < cols and grid[r][c] == '1':
                                q.append([r,c])
                                grid[r][c] = '0'

        return count

        