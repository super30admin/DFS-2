# Time Complexity: O(n)
# Space Complexity: O(n)
# Does this code run on Leetcode: Yes
# Did you face any problems while coding this: No

from collections import deque
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        count = 0
        
        q = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] = '0'
                
                    q.append((i,j))
                    while len(q)!= 0:
                        curr = q.popleft()

                        for x, y in dirs:
                            r, c = curr[0]+x,curr[1]+y
                            if r>=0 and c>=0 and r<m and c<n and grid[r][c] == '1':
                                q.append((r,c))
                                grid[r][c] = '0'
        return count