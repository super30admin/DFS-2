# Time Complexity: O(m * n) where m is the number of rows and n is the number of columns in the grid
# Space Complexity: O(m * n) for the visited cells in the worst case
# Were you able to solve the problem? Yes
# Did you face any challenges while solving the problem? No

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        if not grid or len(grid) == 0:
            return 0

        # DFS Solution

        self.m = len(grid)
        self.n = len(grid[0])
        count = 0
        self.dirs = [(-1,0), (1,0), (0,-1), (0,1)] # U D L R

        def dfs(grid: List[List[str]], i: int, j: int):
            # check if the current cell is within bounds and is a land cell ('1')
            if 0<=i<self.m and 0<=j<self.n and grid[i][j] == '1':
                # mark the cell as visited by changing it to '2'
                grid[i][j] = '2'
                for d in self.dirs:
                    # calculate the new row and column indices based on the direction
                    # and recursively call dfs on the new cell
                    new_i = i + d[0]
                    new_j = j + d[1]

                    dfs(grid, new_i, new_j)
            
        # traverse the grid to find all islands
        # increment count for each new island found and call dfs to mark all connected land cells
        for i in range(self.m):
            for j in range(self.n):
                if(grid[i][j] == '1'):
                    count+=1
                    dfs(grid, i, j)

        return count


          # BFS solution
        # q = deque(())
        # m = len(grid)
        # n = len(grid[0])

        # dirs = [(-1,0), (1,0), (0,-1), (0,1)] # U D L R
        # count = 0

        # # traverse grid to locate all 1s and change to 2 to mark as visited
        
        # for i in range(m):
        #     for j in range(n):
        #         if grid[i][j] == '1':
        #             # increment count of islands when discovering any 1 as new island
        #             count+=1
        #             # push row and col location of 1 into queue, mark cell as visited by setting to 2
        #             q.append( (i,j) )
        #             grid[i][j] = '2'
        #             while q:
        #                 curr = q.popleft()
        #                 # search cell neightbours (UDLR) and add in queue if not visited
        #                 for d in dirs:
        #                     new_i = curr[0] + d[0]
        #                     new_j = curr[1] + d[1]

        #                     if 0<=new_i<m and 0<=new_j<n and grid[new_i][new_j] == '1':
        #                         q.append( (new_i,new_j) )
        #                         grid[new_i][new_j] = '2'

        # return count






                    
        

                    


        