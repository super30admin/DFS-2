# Time Complexity : O(m * n) actually 2mn for the bfs, as if all are 1, 
#  then one pass M * N and second pass to iterate over matrix and check again
# Space Complexity : O(m * n ) for DFS if all are 1, 
#  O(min(m, n)) for BFS, length of biggest diagonal 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# apply bfs, for every 1, increase count, mutate it to 0 
# and add the row index and column index to queue
# in the end return count


from collections import deque
class Solution:

    def numIslands(self, grid):

        if len(grid) == 0 or grid is None:
            return 0
        m, n = len(grid), len(grid[0])
        count = 0
        q = deque()

        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]

        for i in range(m):
            for j in range(n):

                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] = '0'
                    q.append([i, j])

                    while len(q) != 0:
                        curr = q.popleft()
                    
                        for d in dirs:
                            r = d[0] + curr[0]
                            c = d[1] + curr[1]
                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == '1':
                                grid[r][c] = '0'
                                q.append([r, c])
        return count
