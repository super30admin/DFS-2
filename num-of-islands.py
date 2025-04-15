# Approach:
# 1. Traverse the grid and for each unvisited land cell ('1'), perform a BFS to mark all connected land as visited.
# 2. Each time a new unvisited land is found, increment the island count.
# 3. BFS explores all 4 directions (up, down, left, right) and marks connected land as visited.

# Time Complexity: O(N * M) — where N is number of rows and M is number of columns (each cell is visited once)
# Space Complexity: O(N * M) — for the visited set and queue used in BFS

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        visit = set()

        def bfs(r, c):
            q = collections.deque()
            visit.add((r, c))
            q.append((r, c))

            while q:
                r, c = q.popleft()
                directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]

                for dr, dc in directions:
                    row, col = r + dr, c + dc
                    if (
                        0 <= row < rows and
                        0 <= col < cols and
                        grid[row][col] == '1' and
                        (row, col) not in visit
                    ):
                        visit.add((row, col))
                        q.append((row, col))

        islands = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1' and (r, c) not in visit:
                    islands += 1
                    bfs(r, c)

        return islands
