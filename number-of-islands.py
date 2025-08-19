'''
Time Complexity: O(M * N) Where M is the number of rows and N is the number of columns in the grid.
This is because we traverse each cell in the grid at most once.
Space Complexity: O(N) for the queue used in BFS, where N is the maximum number of cells in a single island.
This is the space used for the queue in the worst case, which can hold all cells of
'''

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        queue = deque()
        ROWS, COLS = len(grid), len(grid[0])
        visited = set()
        islands = 0

        for r in range(ROWS):
            for c in range(COLS):
                if (r, c) not in visited and grid[r][c] == "1":
                    if len(queue) == 0:
                        islands += 1

                    queue.append((r, c))

                    while queue:
                        cr, cc = queue.popleft()

                        for dr, dc in directions:
                            nr = dr + cr
                            nc = dc + cc

                            if nr < 0 or nr >= ROWS or nc < 0 or nc >= COLS:
                                continue

                            if (nr, nc) not in visited and grid[nr][nc] == "1":
                                visited.add((nr, nc))
                                queue.append((nr, nc))

        return islands
