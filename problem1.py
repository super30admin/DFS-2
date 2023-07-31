# Time Complexity: O(m * n)
# Space Complexity: O(m * n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        q = deque()
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        count = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    grid[i][j] = "0"
                    q.append([i, j])
                    
                    count += 1
                    while q:
                        level_size = len(q)
                        for _ in range(level_size):
                            r, c = q.popleft()
                            for dr, dc in dirs:
                                row, col = dr + r, dc + c
                                if 0 <= row < m and 0 <= col < n and grid[row][col] == "1":
                                    grid[row][col] = "0"
                                    q.append([row, col])

        return count
