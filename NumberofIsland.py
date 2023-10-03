class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dir = [[-1,0],[1,0],[0,1],[0,-1]]
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                q = deque()
                if grid[i][j] == "1":
                    count += 1
                    q.append([i,j])
                    grid[i][j] = "2"
                    
                    while q:
                        curr = q.popleft()
                        for d in dir:
                            nr = curr[0] + d[0]
                            nc = curr[1] + d[1]
                            if nr >=0 and nc >= 0 and nr < len(grid) and nc < len(grid[0]) and grid[nr][nc] == "1":
                                q.append([nr,nc])
                                grid[nr][nc] = "2"
        
        return count

#TC: O(nm)
#SC: O(nm)