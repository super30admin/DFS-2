# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# change 1s to zero in BFS for every encounter of new one count it as a island

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return -1
        count = 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        Queue = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] = 0
                    Queue.append([i,j])
                    while(len(Queue) != 0):
                        CurrVal = Queue.popleft()
                        for dire in dirs:
                            r = dire[0] + CurrVal[0]
                            c = dire[1] + CurrVal[1]
                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == '1':
                                Queue.append([r,c])
                                grid[r][c] = 0
        return count