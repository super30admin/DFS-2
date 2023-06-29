# Using BFS
# This problem is not like rotting oranges. BFS works differently for both.
#Time and space complexity : O(N) and O(min(m,n)) Min(m,n) because at one point max element in queue could be the diagonal of the matrix
# Algo - We'll go over the grid, whenever we'll encounter 1 we'll increase the count and we'll check if its neighbour is also equal to 1. If yes, we'll add them also into the queue
from queue import Queue
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        columns = len(grid[0])
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        count = 0
        q = Queue()
        for row in range(rows):
            for column in range(columns):
                if grid[row][column] == '1':
                    grid[row][column] ='0' # Make the encountered 1 to 0 so that we wont count it again
                    count+=1 # Increase the count of island
                    q.put([row,column])
                    while not q.empty():
                        curr = q.get()
                        for dir in dirs:
                            nr = curr[0]+dir[0]
                            nc = curr[1]+dir[1]
                            if(nr>=0 and nc >=0 and nr<rows and nc<columns and grid[nr][nc]=='1'):
                                q.put([nr,nc])
                                grid[nr][nc] = '0'
        return count


