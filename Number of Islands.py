'''
Connected Component- BFS traversal for each island.
For each new island found, do a BFS to find the connected land cells.
Time Complexity - O(m*n)
Space Complexity - O(m*n)
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        num_islands = 0
        rows = len(grid)
        cols = len(grid[0])

        directions = [[0,-1],[-1,0],[0,1],[1,0]] # left, top, right, bottom

        for i in range(rows):
            for j in range(cols):
                if grid[i][j]=="1": # found new island
                    num_islands+=1 
                    bfs_queue = deque()
                    bfs_queue.append([i,j]) 
                    grid[i][j] = "0" # mark visited
                    while len(bfs_queue)!=0:
                        row, col = bfs_queue.popleft()
                        for direction in directions:
                            neigh_row, neigh_col = row+direction[0], col+direction[1]

                            if 0<=neigh_row<rows and 0<=neigh_col<cols and grid[neigh_row][neigh_col]=="1":
                                # found connected component, merge with the current island
                                bfs_queue.append([neigh_row,neigh_col])
                                grid[neigh_row][neigh_col]="0"

        return num_islands