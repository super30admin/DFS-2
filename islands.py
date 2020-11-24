# As taught in claass, I used DFS to solve this problem.
# Time Complexity: O(m*n)
#Space Complexity: O(m*n)
def islands(arr):
    if arr is None or len(arr) == 0:
        return 0 
    m = len(arr)
    n = len(arr[0])
    count = 0
    for i in range(m):
        for j in range(n):
            if arr[i][j] == '1':
                count = count + 1
                dfs(arr,i,j)
    return count

def dfs(arr,r,c):
    if (r <0 or r >= len(arr) or c < 0 or c >= len(arr[0]) or arr[r][c] == '0'):
        return
    dirs = [(0,1),(1,0),(-1,0),(0,-1)]
    arr[r][c] = "0"
    for dir in dirs:
        row = dir[0] + r
        col = dir[1] + c
        dfs(arr,row,col)

grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
c = islands(grid)
print(c)




