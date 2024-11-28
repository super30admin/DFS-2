class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])

        direction_array = [(-1,0), (1,0), (0,1), (0,-1)]
        queue = deque()
        count = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    queue.append((i,j))

                    while(queue):
                        value1, value2 = queue.popleft()
                        for dx, dy in direction_array:
                            nr = value1 + dx
                            nc = value2 + dy
                            if (0<= nr < m and 0<=nc < n and grid[nr][nc]=='1'):
                                grid[nr][nc] = '0'
                                queue.append((nr,nc))                 
                    count = count + 1
        return count


        