# Time Complexity : O(MN)
# Space Complexity : O(min(M,N))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS. Check the base condition if the grid is None then return None
# Initialize a queue and update the grid if it is 1 to 0 and increment count by 1 and append the indexes i,j to the queue
# Once that is done, we will iterate over the queue inside the grid until queue is empty and pop the indexes
# Initialize a list of tuples with the 4 directions or neighbors and count to 0
# Iterate over the neighbors and get the row and col index by adding x and y with each neighbor
# Check the boundaries of row and col and check if the grid at index row and col is equal to 1 then append it to queue
# Update the grid at index row and col to 0 until for each level until the queue is not empty
# Then return count

from collections import deque


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return None
        queue = deque()
        count = 0
        neighbors = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    grid[i][j] = "0"
                    queue.append((i, j))
                    while queue:
                        x, y = queue.popleft()
                        for neighbor in neighbors:
                            row = x + neighbor[0]
                            col = y + neighbor[1]
                            if row >= 0 and row < len(
                                    grid) and col >= 0 and col < len(
                                        grid[0]) and grid[row][col] == "1":
                                grid[row][col] = "0"
                                queue.append((row, col))
                    count += 1
        return count