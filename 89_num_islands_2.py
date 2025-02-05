# Time complexity - O(m * n)
# Space complexity - O(min(m, n))

# Approach - bfs - A little bit different approach, need to maintain a visisted set, run a for loop first on
# the matrix, then everytime "1" is found, create a queue, run a bfs on it. Finally outside the while 
# loop, append the number of islands. Finally return the num of islands.

from typing import List
from queue import Queue
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        visited = set()
        dirs = [[0, -1], [0, 1], [1, 0], [-1, 0]]
        islands = 0

        for r in range(m):
            for c in range(n):
                if grid[r][c] == "1" and (r,c) not in visited:
                    q = Queue()
                    q.put((r,c))
                    visited.add((r,c))

                    while not q.empty():
                        curr = q.get()
                        for d in dirs:
                            nr = curr[0] + d[0]
                            nc = curr[1] + d[1]

                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == "1" and (nr, nc) not in visited:
                                q.put((nr, nc))
                                visited.add((nr, nc))
                    islands += 1
        return islands