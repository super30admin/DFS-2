"""
Time Complexity : O(mxn) m is no. of rows and n is no. of cols
Space Complexity : O(mxn) m is no. of rows and n is no. of cols
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0:
            return grid
        count = 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[1,0], [0,1], [-1,0], [0,-1]]
        q = deque()
        # Traverse through the matrix to find '1' and then when we find it do a BFS
        # and count the number of times we carry out BFS that woul dbe the no. of
        # islands
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] = '0'
                    q.append([i, j])
                    # Look out at the neighbors for all the indexes in queue and
                    # append if on the way we discover '1'
                    while q:
                        curr = q.popleft()
                        for item in dirs:
                            r = curr[0] + item[0]
                            c = curr[1] + item[1]
                            # We append the idexes where '1' were found make it '0'
                            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == '1':
                                q.append([r,c])
                                grid[r][c] = '0'
        return count