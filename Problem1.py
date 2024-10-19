# 200. Number of Islands
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        count = 0
        q = deque()
        

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] = '0'
                    q.append([i,j])
                    while q:
                        curr = q.popleft()
                        for dir_ in dirs:
                            r = curr[0] + dir_[0]
                            c = curr[1] + dir_[1]
                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == '1':
                                grid[r][c] = '0'
                                q.append([r,c])
                    
        return count


        