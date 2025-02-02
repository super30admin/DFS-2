#Time: O(m*n)
#Space: O(m*n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        q= list()
        cnt=0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    cnt +=1
                    q.append([i,j])
                    while len(q) !=0:
                        curr = q.pop(0)
                        for direction in dirs:
                            nr= curr[0] + direction[0]
                            nc= curr[1] + direction[1]
                            if nr >=0 and nc >= 0 and nr < m and nc <n:
                                if grid[nr][nc] == "1":
                                    grid[nr][nc] = "2"
                                    q.append([nr,nc])
        return cnt
