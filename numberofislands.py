# Time Complexity : O(M*N) where M is the number of rows and N is the number of columns in the grid
# Space Complexity : O(M*N) where M is the number of rows and N is the number of columns in the grid
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using BFS to traverse the grid starting from each unvisited land cell (1).
# I am keeping track of the number of islands found so far.
# For each unvisited land cell, I increment the island count and perform a BFS to mark all connected land cells as visited.
# I am using a queue to store the cells to be processed.
# I am checking the 4 adjacent cells (up, down, left, right) for each cell.
# If an adjacent cell is within bounds, is land (1), and is unvisited, I mark it as visited and add it to the queue.
# Finally, I return the total number of islands found.



from collections import deque
from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n = len(grid)
        m = len(grid[0])
        visited = [[False]*m for _ in range(n)]
        directions = [(0,1),(1,0),(0,-1),(-1,0)]
        q = deque()
        number = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == '1' and not visited[i][j]:
                    number += 1
                    q.append((i,j))
                    while q:
                        r,c  = q.popleft()
                        for dr,dc in directions:
                            nr = r + dr
                            nc = c + dc
                            if 0 <= nr <n and 0 <= nc < m and grid[nr][nc] == '1' and not visited[nr][nc]:
                                visited[nr][nc] = True
                                q.append((nr,nc))
        return number


        