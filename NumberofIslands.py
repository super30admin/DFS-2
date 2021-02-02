class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """t
        count = 0
        directions = [(0,-1),(0,1),(1,0),(-1,0)]
        q = collections.deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    grid[i][j] = 0
                    q.append((i,j))
                    while q:
                        row,col = q.popleft()
                        for di in directions:
                            r = row+di[0]
                            c = col+di[1]
                            if r>= 0 and r<len(grid) and c >= 0  and c<len(grid[0]) and grid[r][c] =="1":
                                q.append((r,c))
                                grid[r][c] = 0
        return count