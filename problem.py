# TC and SC =  O(r+c) and O(n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        count = 0
        directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]  # Up, Left, Down, Right

        def bfs(r, c):
            queue = [(r, c)]
            while queue:
                curr_r, curr_c = queue.pop(0)
                for dr, dc in directions:
                    nr, nc = curr_r + dr, curr_c + dc
                    # Check bounds and if it's part of the island
                    if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == "1":
                        grid[nr][nc] = "0"  # Mark as visited
                        queue.append((nr, nc))
        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":  # Start a new island traversal
                    count += 1
                    grid[r][c] = "0"  # Mark as visited
                    bfs(r, c)  # Explore the entire island
        
        return count
