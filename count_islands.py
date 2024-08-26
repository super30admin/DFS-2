# time: O(mn)
# space: O(mn)

class Solution(object):
    def numIslands(self, grid):
        # traverse the array- as you get a 1- make it 0 and perform bfs for that 1
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        count = 0
        q = []
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    grid[i][j] == '0'
                    # bfs
                    count += 1
                    q.append([i, j])
                    while q:
                        curr = q.pop(0)
                        for d in dirs:
                            r = d[0] + curr[0]
                            c = d[1] + curr[1]
                            if r >= 0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == '1':
                                q.append([r,c])
                                grid[r][c] = '0'
                                
            
        return count