# tc O(m*n + 4*m*n), sc O(min(m, n)).
ROWS, COLUMNS = len(grid), len(grid[0])
def bfs(row, column):
    queue = deque([(row, column)])
    grid[row][column] = "0"

    while queue:
        row, column = queue.popleft()
        offsets = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        for rowoffset, columnoffset in offsets:
            nr = row + rowoffset
            nc = column + columnoffset
            if 0 <= nr < ROWS and 0 <= nc < COLUMNS and grid[nr][nc] == "1":
                queue.append((nr, nc))
                grid[nr][nc] = "0"

islands_count = 0
for row in range(ROWS):
    for column in range(COLUMNS):
        if grid[row][column] == "1":
            bfs(row, column)
            islands_count += 1

return islands_count