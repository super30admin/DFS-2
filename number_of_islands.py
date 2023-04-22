# Time Complexity: O(m*n)
# Space Complexity: 0(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We traverse through the matrix and if we encounter a 1, we increment the count and call the dfs 
function and we mark the cell as visited by changing it to 2. When we do find a 1, we perform a 
BFS and traverse through the whole island to mark them visited. This will be done continuously 
until we have traversed through the whole matrix to find the total number of islands
"""

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0: return 0

        m, n = len(grid), len(grid[0])
        count = 0
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count+=1
                    q = deque()
                    q.append([i,j])
                    grid[i][j] = 2
                    while q:
                        curr = q.popleft()
                        for Dir in dirs:
                            nr = curr[0] + Dir[0]
                            nc = curr[1] + Dir[1]

                            if nr>=0 and nr<m and nc >=0 and nc < n and grid[nr][nc] == '1':
                                grid[nr][nc] = '2'
                                q.append([nr,nc])

        return count