class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # T: O(m * n), S: O(m * n)
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        islands = 0
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]  # Down, Up, Right, Left

        def bfs(r, c):
            queue = deque([(r, c)])
            grid[r][c] = "0"  # Mark as visited

            while queue:
                row, col = queue.popleft()
                for dr, dc in directions:
                    nr, nc = row + dr, col + dc
                    if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == "1":
                        queue.append((nr, nc))
                        grid[nr][nc] = "0"  # Mark as visited

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":  # Found an island
                    bfs(r, c)
                    islands += 1

        return islands
