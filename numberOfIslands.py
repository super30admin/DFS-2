"""
Traverse each cell; when we find '1', it's a new island
Apply DFS/BFS from there to mark all connected '1's as visited
Repeat for all cells and count the islands
"""
"""
Time Complexity: O(m × n) All cells visited
Space Complexity: O(m × n) in worst case due to DFS recursion stack
Can be reduced with BFS or iterative DFS using stack
"""

from typing import List

class numberOfIslands:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        count = 0

        def dfs(r, c):
            if r < 0 or c < 0 or r >= rows or c >= cols or grid[r][c] != '1':
                return
            grid[r][c] = '0'
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    count += 1
                    dfs(r, c)

        return count

if __name__ == "__main__":
    obj = numberOfIslands()
    grid = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
    ]
    print(obj.numIslands(grid))


"""
BFS Solution

def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        count = 0
        directions = [(-1,0), (1,0), (0,-1), (0,1)]

        def bfs(r, c):
            queue = deque()
            queue.append((r, c))
            grid[r][c] = '0'  # mark as visited

            while queue:
                cr, cc = queue.popleft()
                for dr, dc in directions:
                    nr, nc = cr + dr, cc + dc
                    if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == '1':
                        queue.append((nr, nc))
                        grid[nr][nc] = '0'  # mark visited

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    count += 1
                    bfs(r, c)

        return count

"""
