'''
// Time Complexity :
# Problem 1: O(2(m*n)) as we parse the entire grid + queue (hence twice)
# Problem 2: O(n) as we parse through the entire string
// Space Complexity :
# Problem 1: O(m*n) as store all elements in a queue
# Problem 2: O(n) as we use result array to return the concatenated string
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
'''
## Problem 1 - Number of Islands (BFS)
# Use a standard boiler plate for directions. Initialize a queue to store leaf nodes. 
# We increment the count whenever we reach a '1', then we will check for all neighbouring elements and
# replace them by '0' to make sure we do not repeat
# We parse through all the nodes and keep on popping it from the stack until the entire grid is done.
# Return count which is total number of islands.
 
from collections import deque

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        
        count = 0
        dirs =[[-1,0], [1,0], [0,-1], [0,1]]
        if grid == None: return count
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    queue = deque()
                    queue.append([i,j])
                    grid[i][j] = '0'
                    while len(queue) > 0:
                        curr = queue.popleft()
                        for dir in dirs:
                            nr = dir[0] + curr[0]
                            nc = dir[1] + curr[1]
                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == '1':
                                queue.append([nr, nc])
                                grid[nr][nc] = '0'
        return count

## Problem 2 - Decode String
# Initialize a stack to maintain the string character followed by a digit.
# We parse over the string, if the character is a digit then we update the number of times the char 
# needs to be considered.
# If the string has an opening bracket then we push the string character and number to the stack
# If the string has an closing bracket then we pop the string and the digit
# Update the resultant string after the pop function and concatenate until the stack is empty. 

from collections import deque
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = []
        currStr = ''
        currNum = 0
        digits = '0123456789'

        for i in range(len(s)):
            ch = s[i]
            if ch in digits:
                currNum = (currNum * 10) + int(ch)
            elif ch == '[':
                stack.append([currStr, currNum])
                currStr = ''
                currNum = 0
            elif ch == ']':
                node = stack.pop()
                prevStr = node[0]
                prevNum = node[1]
                currStr = prevStr + (currStr * prevNum)
            else:
                currStr += ch
        return currStr
