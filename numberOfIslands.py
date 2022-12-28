# // Time Complexity : O(MN) for both bfs and dfs . it will actually be 2(MN) but we drop the constant
# // Space Complexity : O(MN)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
## in the DFS solution we start our dfs from all the points we find a "1".  then we go in all 4 directions 
## and see if we have more 1s. we make all those 0s and once our initital dfs return we increase count. we go over
## the grid and perform this on all posisble 1s.
class solution:

    def dfs(self, grid):
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    self.helper(grid, i, j)
                    count+=1
        return count
    def helper(self, grid, row, col):

        if row < 0 or row>= len(grid) or col >= len(grid[0]) or col <0 or grid[row][col]== "0":
            return 
        
        grid[row][col]="0"
        dir = [[1,0],[-1,0], [0,1], [0,-1]]
        for d in dir:
            new_r = row+d[0]
            new_c = col+d[1]
            self.helper(grid, new_r, new_c)
    
## this is also similar. We go to a cell where we have a 1 and move outwards in all 4 directions. if we find a 1 we add it to our q and change it to 0 
## we do this across the whole grid and get the count everytime we come across a 1 .
    def bfs(self, grid):
        
        count =0
        dir = [[1,0],[-1,0], [0,1], [0,-1]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                queue = collections.deque()

                if grid[i][j] == "1":
                    queue.append([i,j])
                    count+=1
                    while queue:
                        curr = queue.popleft()

                        for d in dir:
                            new_r = curr[0]+d[0]
                            new_c = curr[1]+d[1]
                            if new_r >= 0 and new_c>= 0 and new_r<len(grid) and new_c <len(grid[0]) and grid[new_r][new_c] == "1":
                                queue.append([new_r, new_c])
                                grid[new_r][new_c] = "0"
        
        return count

