########### Number of islands

# Time Complexity : O(e+v)
# Space Complexity : O(e+v)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :  No


# Starting from the land perform dfs until connecting land is discovered. Once done processing an island increment island count by 1 and find new land to start dfs from.

def number_of_islands(grid):
        cnt = 0
        for r, row in enumerate(grid):
            for c, _ in enumerate(row):

                if grid[r][c]=="1":
                    stack = [(r,c)]
                    while stack:
                        x,y = stack.pop()
                        grid[x][y]="0"
                        for dx,dy in ((x-1,y),(x+1,y),(x,y-1),(x,y+1)):
                            if dx >=0 and dy >=0 and dx<len(grid) and dy<len(row) and grid[dx][dy] == "1":
                                stack.append((dx,dy))
                    cnt+=1
        return cnt
