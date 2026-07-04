## Problem1 (https://leetcode.com/problems/number-of-islands/)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        # ==========================================
        # BFS Solution
        # Time Complexity: $O(M \times N)$ where M is the number of rows and N is columns.
        # Space Complexity: $O(\min(M, N))$ in the worst case for the queue size.
        # ==========================================
        
        # q = collections.deque()
        # rows = len(grid)
        # cols = len(grid[0])
        # islands = 0
        # directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]

        # # Iterate through the grid cell by cell to find starting points
        # for r in range(rows):
        #     for c in range(cols):
        #         # When a piece of unvisited land ("1") is encountered...
        #         if grid[r][c] == "1":
        #             islands += 1       # Increment the overall island count
        #             grid[r][c] = "0"   # Turn into water ("0") to ensure it's not processed again
        #             q.append([r, c])   # Add to queue to start the BFS
        #             
        #             # Perform Breadth-First Search (BFS) layer by layer
        #             while q:
        #                 cr, cc = q.popleft()
        #                 
        #                 # Explore all 4 directly connected adjacent cells
        #                 for dr, dc in directions:
        #                     nr, nc = cr + dr, cc + dc
        #                     
        #                     # If the adjacent cell is within bounds...
        #                     if nr >= 0 and nc >= 0 and nr < rows and nc < cols:
        #                         # ...and is also land, mark it visited and queue it
        #                         if grid[nr][nc] == "1":
        #                             grid[nr][nc] = "0"
        #                             q.append([nr, nc])

        # return islands


        # ==========================================
        # DFS Solution
        # Time Complexity: $O(M \times N)$ where M is the number of rows and N is columns.
        # Space Complexity: $O(M \times N)$ in the worst case for the recursion call stack.
        # ==========================================
        
        rows = len(grid)
        cols = len(grid[0])
        islands = 0
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]

        # Helper function to recursively explore as deeply as possible
        def dfs(r, c):
            nonlocal rows, cols, directions

            # Turn visited "1"s into "0"s to track visited states without extra memory
            grid[r][c] = '0'
            
            # Explore all 4 directly connected adjacent cells
            for dr, dc in directions:
                nr, nc = r + dr, c + dc

                # If the adjacent cell is within bounds and is unvisited land, recursively visit it
                if nr >= 0 and nr < rows and nc >= 0 and nc < cols and grid[nr][nc] == '1':
                    dfs(nr, nc)

        # Iterate through the grid cell by cell to find unvisited land
        for r in range(rows):
            for c in range(cols):
                # When unvisited land ("1") is encountered...
                if grid[r][c] == '1':
                    islands += 1  # We found a new, distinct island
                    dfs(r, c)     # Sink the entire island by triggering the DFS

        return islands