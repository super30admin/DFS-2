class Solution(object):
    # tc : O(m*n) for both bfs, dfs
    # sc : O(min(m,n)) for bfs as at the worst case we end up having all the diagonal of the matrix elemenst inside the queue, for dfs the recurssive stack the worst case will be havign all elements O(m*n) in it 
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        # intution: iterate through the matrix and once found 1 check the connected componens that is the 4 directions and see if there are any 1 .. and change that cell into 0 
        # once in the bfs the neighbors of the cell no more 1's are found we found a piece of island in the matrix where we have the count of the islands and return the count

        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count +=1 # once we found a 1 we found a island we increase the count
                    self.bfs(grid, i, j) # the bfs make sure it makes all its connected components to 0 making all the connected components as a single piece of island
                    # self.dfs(grid,i,j) # it can also be doen using the dfs as well 

        return count

    def bfs(self,grid,i,j):
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        q = deque()
        q.append([i,j])
        grid[i][j] = "0" # change that cell into 0 

        while q: # process its neighbors
            cell = q.popleft()
            for dir in dirs:
                neighbor_row = cell[0] + dir[0]
                neighbor_col = cell[1] + dir[1]

                # bounds check
                if neighbor_row >= 0 and neighbor_row < len(grid) and neighbor_col >= 0 and neighbor_col < len(grid[0]) and grid[neighbor_row][neighbor_col] == "1":
                    grid[neighbor_row][neighbor_col] = "0" # change it to 0, # add that cell to queue to process the neighbors
                    q.append([neighbor_row, neighbor_col])

    # def dfs(self,grid,i,j):
    #     dirs = [[-1,0], [1,0], [0,-1], [0,1]]

    #     for dir in dirs:
    #         neighbor_row = i + dir[0]
    #         neighbor_col = j + dir[1]

    #         # bounds check
    #         if neighbor_row >= 0 and neighbor_row < len(grid) and neighbor_col >= 0 and neighbor_col < len(grid[0]) and grid[neighbor_row][neighbor_col] == "1":
    #             grid[neighbor_row][neighbor_col] = "0"
    #             self.dfs(grid,neighbor_row,neighbor_col)




