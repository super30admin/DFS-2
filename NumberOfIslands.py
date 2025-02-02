# Time Complexity : O(m * n), m is no of rows and n is no of columns
# Space Complexity : O(m + n) or O(max(m, n)) because not all elements go inside the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# while traversing the grid for 1's, when we find a 1, we found an island
# we perform  BFS for this particular 1,  to find all neighbouring 1 elements
# then we mark them visited by changing them to 2
# and we look for all the neighbours (looking for 1s)
# so we have 2 loops - 1. for traversing the grid, and 2 - for BFS
# but TC is O( m * n) because we mark visited elements as 2, and we do not perform BFS for visited elements again

from collections import deque

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """

        if grid is None:
            return 0 # no islands
        
        m = len(grid)
        n = len(grid[0])
        count = 0
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

        # traverse over the grid
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    # we should start our BFS
                    q = deque([[i,j]])
                    # now we will find one island
                    count += 1
                    # and change the value of this 1 to 2
                    grid[i][j] = "2"

                    # starting bfs
                    while q:
                        curr = q.popleft() # coodinates of the current 1 element
                        # checking for all neighbours using dirs
                        for dir in dirs:
                            nr = dir[0] + curr[0]
                            nc = dir[1] + curr[1]
                            # checking if the nr and nc are valid, and they have a 1
                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == "1":
                                q.append([nr, nc])
                                # and then change it to 2
                                grid[nr][nc] = "2"
                        
                    # BFS completed 
        
        # traversal completed
        return count






        