# Time Complexity : O(MN)
# Space Complexity : O(min(M,N))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS. Check the base condition if the grid is None then return None
# Initialize a queue and update the grid if it is 1 to 0 and increment count by 1 and append the indexes i,j to the queue
# Once that is done, we will iterate over the queue inside the grid until queue is empty and pop the indexes
# Initialize a list of tuples with the 4 directions or neighbors
# Iterate over the neighbors and get the row and col index by adding i and j with each neighbor
# Check the boundaries of row and col and check if the grid at index row and col is equal to 1 then append it to queue
# Update the grid at index row and col to 0 until for each level until the queue is not empty
# Then return count


from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        if not grid:
            return count
        m = len(grid)
        n = len(grid[0])
        queue = deque()
        dirs = {(0,1), (1,0), (0,-1), (-1,0)}
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    queue.append((i,j))
                    count += 1
                    grid[i][j] = "0"
                    while queue:
                        row, col = queue.popleft()
                        for dir in dirs:
                            r = row + dir[0]
                            c = col + dir[1]
                            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == "1":
                                grid[r][c] = "0"
                                queue.append((r,c))

        return count
#BFS

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    count += 1
                    self.helper(grid, i, j)
        return count

    
    def helper(self, grid, r, c):
        if r < 0 or r >= self.m or c < 0 or c >= self.n or grid[r][c] == "0":
            return
        grid[r][c] = "0"
        dirs = {(0,1), (1,0), (0,-1), (-1,0)}
        for dir in dirs:
            row = r + dir[0]
            col = c + dir[1]
            self.helper(grid, row, col)
    