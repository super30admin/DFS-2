from typing import List
from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid[0])==0: return 0
        dir=[[0,1],[0,-1],[1,0],[-1,0]]
        row=len(grid)-1
        column=len(grid[0])-1
        count=0
        levelorder=deque()
        for rowindex in range(row):
            for columnindex in range(column):
                if grid[rowindex][columnindex]=='1':
                    count+=1
                    levelorder.append([rowindex,columnindex])
                    grid[rowindex][columnindex]=0
                    while levelorder.__len__()>0:
                        node=levelorder.popleft()

                        for d in dir:
                            r=d[0]+node[0]
                            c=d[1]+node[1]
                            if r>=0 and r<row and c>=0 and c<column and grid[r][c]=='1':
                                grid[r][c]='0'
                                levelorder.append([r,c])

        return count











if __name__ == '__main__':
    grid = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"]
    ]
    print(Solution().numIslands(grid=grid))
