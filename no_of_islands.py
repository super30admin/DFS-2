"""
Time complexity --> O(m*n)
Space Complexity --> O(min(m,n)), because our BFS is moving top to down, left to right, and so the maximum number of elements in the queue will be the diagonal of the grid.
"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        queue = deque()
        rows = len(grid)
        cols = len(grid[0])
        visited = set()
        islands = 0
        directions =[[0,1],[0,-1],[1,0],[-1,0]]


        for i in range(rows):
            for j in range(cols):

                if grid[i][j]=='1' and (i,j) not in visited:
                    islands+=1

                    queue.append([i,j])
                    visited.add((i,j))

                    while queue:

                        curr_i, curr_j = queue.popleft()

                        for dir_i, dir_j in directions:

                            upd_i, upd_j = curr_i+dir_i, curr_j+dir_j

                            if upd_i in range(rows) and upd_j in range(cols):

                                if(grid[upd_i][upd_j]=='1' and (upd_i,upd_j) not in visited):
                                    queue.append([upd_i,upd_j])
                                    visited.add((upd_i,upd_j))


        return islands




