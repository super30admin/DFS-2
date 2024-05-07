## Problem1 (https://leetcode.com/problems/number-of-islands/)

# Approach
# Traverse through the grid and find first 1. Set it to 0 and add it to the queue. Increment count. 
# While queue is not empty, pop leftmost element and check its all 4 neighbors. If its value is 1, set it to 0 and add it to the queue.
# Once the queue is empty, and all the elements are traversed, return count

# Time Complexity: O(m*n)
# Space Complexity : O(min(m,n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        count = 0
        q = deque()
        direction = [[1,0],[0,1],[-1,0],[0,-1]]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    q.append((i,j))
                    grid[i][j] == '0'
                    while q:
                        r,c = q.popleft()
                        for d in direction:
                            nr = r + d[0]
                            nc = c + d[1]
                            if (0<=nr<m and 0<=nc<n and grid[nr][nc] == '1'):
                                grid[nr][nc] = '0'
                                q.append((nr,nc))
        return count