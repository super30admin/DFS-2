class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        # Time and space complexity O(Rows*Cols)
        if not grid:
            return 0
        # DFS - Iterative - Stack
        # BFS = Queue - queue.popleft
        Rows = len(grid)
        Cols = len(grid[0])
        count = 0
        visited = set()
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def DFS(i, j):
            # queue = collections.deque()
            # queue.append((i,j))
            stack = [(i, j)]
            # while queue:
            while stack:
                # u = queue.popleft() # use for bfs
                u = stack.pop()
                r = u[0]
                c = u[1]
                visited.add((r, c))
                for dr, dc in directions:
                    row = dr + r
                    col = dc + c
                    if (Rows > row >= 0) and (Cols > col >= 0) and grid[row][col] == "1" and (row, col) not in visited:
                        # queue.append((row,col))
                        stack.append((row, col))

        for i in range(Rows):
            for j in range(Cols):
                if grid[i][j] == "1" and (i, j) not in visited:
                    count += 1
                    DFS(i, j)

        return count




