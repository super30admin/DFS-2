#problem 1:Number of islands
#time complexity: O(n), elements in the matrix
#space complexity: O(n) recursive stack

'''
We iterate through the matrix and when we find a 1, we DFS from that 1 while changing it and
every 1 we can reach to 0 (because they are from the same island). Everytime we encounter a
1 we increase the count. Careful, the numbers are string. the count should be at
the end of a GLOBAL dfs call and not inside the recursion
'''

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        n,m=len(grid),len(grid[0])
        islands=0
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        def dfs(i,j):
            nonlocal n,m
            if not (0<=i<n) or not (0<=j<m) or grid[i][j]!="1":
                return

            grid[i][j]="0"
            for d in dirs:
                dfs(i+d[0],j+d[1])

        for r in range(n):
            for c in range(m):
                if grid[r][c]=="1":
                    dfs(r,c)
                    islands+=1

        return islands



#Problem 2: Decode String
#Time Complexity: O(n), number of characters in the string
#Space Complexity: O(n), worst case for recursive stack

'''
As we traverse the string, if we encounter a number, we change
the local number to that number. if we encounter [, we call recursively
the function on what's after the [. then whatever this recursive
call output, we multiply it by the local number, which is the
number before the [. if we encounter ] , it means that we need to return
what our local string is (every call is bounded by a [  ]).  Finally
if it's not a number or [, ], then we simply add the letter to the our
local string. The local string of the first call is what we return.
don't forget to make i global as we traverse the string.
'''

class Solution:
    def decodeString(self, s: str) -> str:
        i=0
        def helper(s):
            nonlocal i
            if not s:
                return ""
            res=""
            local_number=1
            while i<len(s):
                if s[i].isnumeric():
                    local_number=int(s[i])
                    i+=1
                    while i<len(s) and s[i].isnumeric():
                        local_number=local_number*10+int(s[i])
                        i+=1

                elif s[i]=="[":
                    i+=1
                    in_s=helper(s)
                    for j in range(local_number):
                        res+=in_s

                elif s[i]=="]":
                    i+=1
                    return res
                else:
                    res+=s[i]
                    i+=1
            return res
        res=helper(s)
        return res
