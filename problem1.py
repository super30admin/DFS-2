#time complexity O(m*n)
#space comlexity O(m*n)

#dfs in djs passing the pair of coordinate of first occurance of 1 then applying dfs from that pair in all 4 direction and making grid value to 0 if 1 is there thats how island which have 1 near me will be group together and after that increasing the count
# making 1 to 0 means not repeating that pair again (island again).

# then again checking for 1 again.
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count=0
        queue=[]
        _dir=[[0,1],[1,0],[-1,0],[0,-1]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    queue.append([i,j])
                    grid[i][j]='0'
                    while queue:
                        temp=queue.pop(0)
                        for d in _dir:
                            r=temp[0]+d[0]
                            c=temp[1]+d[1]
                            if r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c]=='1':
                                queue.append([r,c])
                                grid[r][c]='0'
                    count+=1
        return count

