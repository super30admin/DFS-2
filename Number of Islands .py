
class Solution:
    # BFS 
    # time : O(M*N) ; space : O(1)
    # NOTE: once a '1' is visited, increase count += 1, change it to '0' immediately (avoid deadlock ~ infinte loop), 
            # change all its nbrs to '0' by dfs (reursively call dfs on nbrs and change it to '0') or bfs (add nbrs to queue) 

    def numIslands(self, grid):
        # EDGE CASE
        if grid == [] or len(grid) == 0:
            return 0
        
        q = []
        count = 0
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    q.append([i, j])
                    grid[i][j] = '0'
                    count += 1
                    while q != []:
                        root = q.pop(0)
                        for dir in dirs:
                            r = root[0] + dir[0]
                            c = root[1] + dir[1]
                            if r >= 0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == '1':
                                q.append([r, c])
                                grid[r][c] = '0'
        return count


# ===================================================================================================================================

    # DFS 
    # time : O(M*N)
    # space : O(1) + Recursive call stack

    def numIslands(self, grid):
        # EDGE CASE
        if grid == [] or len(grid) == 0:
            return 0

        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    self.helper(grid, i, j)
        return count

    def helper(self, grid, i, j):
        # BASE CASE
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0':
            return

        # LOGIC
        grid[i][j] = '0'
        dirs = [ [0, 1], [0, -1], [1, 0], [-1, 0] ]
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            self.helper(grid, r, c)



obj = Solution()
print(obj.numIslands(grid=[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]))
                        
        

        

        
