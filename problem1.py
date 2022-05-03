#Number of islands

# // Time Complexity :O(N*M) - Going though every grids or bfs from one grid
# // Space Complexity : O(min(n, m)) the max value on the queue could only be the min of n or m
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def numIslands( grid):
    if grid==None: return grid
    queue=[]
    directions=[[1,0],[0,1],[-1,0],[0,-1]]
    islands=0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if(grid[i][j]=="1"):                            #conduct bfs if you find a "1"
                queue.append((i,j))                         #add that row and col to the queue
                while(queue):
                    value=queue.pop(0)
                    grid[i][j]="0"                          #make the value to "0"
                    for d in directions:
                        r = value[0]+d[0]
                        c = value[1]+d[1]
                        if(r>=0 and c>=0 and r<len(grid) and c<len(grid[0]) and grid[r][c]=="1"):   #if the neighbor is a "1", then change it to "0" and add it to the queue to do a bfs later
                            grid[r][c]="0"
                            queue.append((r,c))
                islands+=1                              #after being done with the queue increment the number of islands
    return islands


#test
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
print(numIslands(grid))