"""
Time complexity: O(M * N)
Space complexity: O( sqrt(M^2 + N^2))
Compiled on leetcode: Yes
Difficulties faced: No
"""
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        islandCount = 0
        m = len(grid)
        n = len(grid[0])
        dirs = ((1,0), (-1,0), (0, -1), (0, 1))
        queue = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    queue.append((i,j))
                    while queue:
                        currentIndex = queue.popleft()
                        grid[currentIndex[0]][currentIndex[1]] = '0'
                        for dir in dirs:
                            r = dir[0] + currentIndex[0]
                            c = dir[1] + currentIndex[1]
                            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == '1':
                                grid[r][c] = '0'
                                queue.append((r,c))
                    islandCount += 1
        return islandCount 