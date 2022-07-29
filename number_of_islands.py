# Time complexity: O(mn)
# Space complexity: O(min(m,n))
# BFS: traverse each and every element in matrix if there is 1,
# put that into a queue and check for its neighbours if they are 1- like a chain
# make it 0, and enter the neighbours that are 1 into the queue, 
# and make them also zero so that , we dont visit the same element again.
# the chain will be captured until the queue is not empty.
# By doing this, we capture the grouped island as one instead of multiple islands.
# do the outer loop for all the indices, and capture the islands in the outside loop.



class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        from queue import Queue
        dirs = [[0,1],[0,-1],[-1,0],[1,0]]
        m = len(grid)
        n = len(grid[0])
        total = 0
        for i in range(0,m):
            for j in range(0,n):
                if grid[i][j]=='1':
                    total = total + 1
                    q = Queue()
                    grid[i][j]='0'
                    q.put([i,j])
                    while not q.empty():
                        curr = q.get()
                        # print(curr)
                        for dir in dirs:
                            nr = dir[0]+curr[0]
                            nc = dir[1]+curr[1]
                            if(nr>=0 and nr<m and nc >=0 and nc < n and grid[nr][nc]=='1'):
                                q.put([nr,nc])
                                grid[nr][nc]='0'
        return total
                
                                
                                
                        
                    
                
        