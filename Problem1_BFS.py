# Using BFS
# Time complexity : O(n*m)
# Space complexity : O(n*m)
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        # check if len of grid is zero or list is null
        rows = len(grid)
        if not grid or rows == 0:
            return 0
        cols = len(grid[0])        
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        count = 0
        q = deque([])
        
        # we start when we first reach a 1 in the matrix, add it to the queue
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    #print(i,j)
                    count += 1
                    # increment the count and change the value to 2
                    grid[i][j] = '2'
                    q.append((i,j))
                    
                    # we traverse until the queue is empty
                    while q:
                        # traverse the whole level in BFS
                        for k in range(len(q)):
                            row, col = q.popleft()
                            # check for neighboring cells, if anyone of them is 1, add it to the queue
                            # make the current index value as 2
                            for di in dirs:
                                r = row + di[0]
                                c = col + di[1]
                                if r >= 0 and r < rows and c >= 0 and c < cols and grid[r][c] == '1':
                                    q.append((r,c))
                                    grid[r][c] = '2'
        # This way we traberse all the connected components, and increment the count only when
        # we find an isolated 1 in the matrix
        return count
