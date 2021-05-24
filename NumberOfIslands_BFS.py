# TC: O(M x N) since we will end up processing all the characters in the input array. 
# SC: O(min(M,N)) where M is the number of rows and N os the number of columns. 

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or len(grid) == 0 or len(grid[0]) == 0:
            return 
        
        count = 0
        queue = collections.deque()
        rows = len(grid)
        cols = len(grid[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] = '0'
                    queue.append((i,j))
                    while queue:
                        curr_x, curr_y = queue.popleft()
                        for x,y in dirs:
                            new_x, new_y = curr_x + x, curr_y + y
                            if new_x >= 0 and new_x < rows and new_y >= 0 and new_y < cols and grid[new_x][new_y] == '1':
                                queue.append((new_x, new_y))
                                grid[new_x][new_y] = '0'
        return count
