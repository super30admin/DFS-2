#time = O(M×N)
#space = O(M×N)
def numIslands(grid):
    if not grid:
        return 0

    def dfs(grid, r, c):
        grid[r][c] = '0'  # Mark as visited
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]  # Down, Up, Right, Left
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and grid[nr][nc] == '1':
                dfs(grid, nr, nc)

    num_islands = 0
    for r in range(len(grid)):
        for c in range(len(grid[0])):
            if grid[r][c] == '1':
                num_islands += 1
                dfs(grid, r, c)

    return num_islands
# DFS Function: The dfs function marks the current cell as visited by changing '1' to '0'. 
# Then, it recursively visits all the adjacent cells (up, down, left, right) that are '1'.

# Main Function: The numIslands function iterates through each cell in the grid. 
# When it finds an unvisited '1', it increases the island count and starts a DFS to mark the entire island as visited.