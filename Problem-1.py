# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
from collections import deque
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        #count of islands = 0
        count = 0
        queue = deque()
        directions = [[0,1],[0,-1],[1,0],[-1,0]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                #find a one change it to negative one and start DFS
                if grid[i][j] == '1':
                    grid[i][j] = '-1'
                    queue.append([i,j])
                    #found an island
                    count +=1
                while queue:
                    #check node
                    curr = queue.popleft()
                    #see 4 directions
                    for direction in directions:
                        r = curr[0] + direction[0]
                        c = curr[1] + direction[1]
                        # if in bound and location = 1 change it to -1 and append it to island
                        if r >=0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == '1':
                            grid[r][c] = '-1'
                            queue.append([r,c])
                #finished island
                
                
        return count