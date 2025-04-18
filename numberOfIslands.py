# Time Complexity : O(m*n), where m is the number of rows and n is the number of columns in the grid.
# Space Complexity : O(min(m,n)), because our BFS is moving top to down, left to right, and so the maximum number of elements in the queue will be the diagonal of the grid.
# Did you run the code on Leetcode : Yes
# Any problem you faced while coding this : No

# Approcah:
# We will use BFS to traverse the grid.
# We will use a queue to store the cells that we need to visit.
# We will use a set to store the cells that we have already visited.
# We will iterate through the grid and for each cell that is not visited and is land, we will increment the number of islands and call the bfs function.
# In the bfs function, we will add the cell to the queue and mark it as visited.
# We will then pop the cell from the queue and check its neighbours. If the neighbour is not visited and is land, we will add it to the queue and mark it as visited.
# Finally, we will return the number of islands.

from collections import deque
class Solution:
    def numIslands(self, grid):
        # Check if the grid is empty, if it is, return 0, there are no islands
        if not grid:
            return 0
        # Calculate the number of rows and columns in the grid
        m, n = len(grid), len(grid[0])
        # Initialize a set to keep track of visited cells
        visit = set()
        # Initialize a variable to keep track of the number of islands
        islands = 0

        # Define a BFS function to traverse the grid
        def bfs(i, j):
            # Define the directions for moving up, right, down, and left
            dirs = [[-1,0], [0,1], [1,0], [0,-1]]
            # Initialize a queue for BFS
            q = deque()
            # Add the starting cell to the queue and mark it as visited
            q.append([i, j])
            visit.add((i, j))

            # While there are cells in the queue, continue processing
            while q:
                # Pop the first cell from the queue
                cell = q.popleft()
                # Check all 4 possible directions
                for row, col in dirs:
                    # Calculate the new row and column indices
                    r = cell[0] + row
                    c = cell[1] + col
                    # Check if the new indices are within bounds, not visited, and is land, if so, add it to the queue and mark it as visited
                    if r>=0 and c>=0 and r<m and c<n and (r,c) not in visit and grid[r][c] == "1":
                        q.append([r,c])
                        visit.add((r,c))

        # Iterate through the grid
        for i in range(m):
            for j in range(n):
                # For each cell, if it is not visited and is land, increment the number of islands and call the bfs function
                if (i, j) not in visit and grid[i][j] == "1":
                    islands += 1
                    bfs(i, j)

        # Return the number of islands
        return islands
    
# Time Complexity : O(m*n), where m is the number of rows and n is the number of columns in the grid.
# Space Complexity : O(m*n), because we are using a set to store the visited cells.
# Did you run the code on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# We will use DFS to traverse the grid.
# How DFS works:
# For each cell that is land, we will mark it as visited and check its neighbours.
# If the neighbour is not visited and is land, we will mark it as visited and check its neighbours.
# We will do this until we have visited all the cells in the island.
# DFS will process 1 neighbor at a time and will go deep into the island until it reaches the end.
# Finally, we will return the number of islands.

class Solution:
    def numIslands(self, grid) -> int:
        if not grid:
            return 0
        m, n = len(grid), len(grid[0])
        dirs = [[-1,0], [0,1], [1,0], [0,-1]]
        islands = 0

        # Define a DFS function to traverse the grid
        def dfs(i, j):
            # We will only reach here if the cell is inbounds, is a land, and is not visited
            # Mark the cell as visited
            # We will mark the cell as visited by changing its value to 0
            grid[i][j] = 0

            # Check all 4 possible directions
            for row, col in dirs:
                # For each direction, calculate the new row and column indices
                r = i+row
                c = j+col
                # Check if the new indices are within bounds, not visited, and is land, if so, call dfs on it
                if r>=0 and c>=0 and r<m and c<n and grid[r][c] == "1":
                    dfs(r, c)

        # Iterate through the grid
        for i in range(m):
            for j in range(n):
                # For each cell, if it is not visited and is land, increment the number of islands and call the dfs function
                if grid[i][j] == "1":
                    islands += 1
                    # define
                    dfs(i, j)

        # Return the number of islands
        return islands